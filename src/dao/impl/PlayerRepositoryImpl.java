package dao.impl;

import dao.KeyGenerator;
import dao.PlayerRepository;
import model.Player;

public class PlayerRepositoryImpl extends RepositoryMemoryImpl<Long, Player> implements
        PlayerRepository {

public PlayerRepositoryImpl(KeyGenerator<Long> keyGenerator) {
        super(keyGenerator);
        }
        }
