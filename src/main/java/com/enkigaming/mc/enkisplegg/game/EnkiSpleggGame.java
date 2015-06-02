package com.enkigaming.mc.enkisplegg.game;

import com.enkigaming.mc.lib.misc.PlayerPosition;
import com.enkigaming.mc.lib.pvp.PvpGame;
import com.enkigaming.mc.lib.pvp.PvpTeam;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class EnkiSpleggGame extends PvpGame
{
    Collection<PlayerPosition> startingPositions;
    
    @Override
    public void teleportPlayersToStartingPositions()
    {
        Random random = new Random();
        List<PlayerPosition> positions = new ArrayList<PlayerPosition>(startingPositions);
        List<PlayerPosition> positionsToBeUsed = new ArrayList<PlayerPosition>(positions);
        
        synchronized(players)
        {
            for(UUID i : players.keySet())
            {
                if(positionsToBeUsed.isEmpty())
                    positionsToBeUsed = new ArrayList<PlayerPosition>(positions);
                
                int positionToUse = random.nextInt(positionsToBeUsed.size());
                PlayerPosition position = positionsToBeUsed.remove(positionToUse);
            }
        }
    }

    @Override
    protected GameStates getNewGameStatesObject()
    { return new GameStates(); }

    @Override
    protected Collection<PvpTeam> getNewTeams(Collection<UUID> clctn)
    {
        Collection<PvpTeam> teams = new HashSet<PvpTeam>();
        
        for(UUID player : clctn)
            teams.add(new PvpTeam(player));
        
        return teams;
    }
}