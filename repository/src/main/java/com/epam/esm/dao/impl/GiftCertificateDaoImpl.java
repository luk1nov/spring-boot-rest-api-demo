package com.epam.esm.dao.impl;

import com.epam.esm.dao.GiftCertificateDao;
import com.epam.esm.model.GiftCertificate;
import com.epam.esm.model.Tag;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.*;

@Component
@Log4j2
public class GiftCertificateDaoImpl implements GiftCertificateDao {

    private EntityManager entityManager;
    private CriteriaBuilder criteriaBuilder;

    @Autowired
    public GiftCertificateDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.criteriaBuilder = entityManager.getCriteriaBuilder();
    }

    @Override
    public GiftCertificate insert(GiftCertificate giftCertificate) {
        /*KeyHolder keyHolder = new GeneratedKeyHolder();
        log.info(giftCertificate);
        jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement(INSERT_CERTIFICATE, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, giftCertificate.getName());
            ps.setString(2, giftCertificate.getDescription());
            ps.setBigDecimal(3, giftCertificate.getPrice());
            ps.setInt(4, giftCertificate.getDuration());
            ps.setTimestamp(5, Timestamp.valueOf(giftCertificate.getCreateDate()));
            ps.setTimestamp(6, Timestamp.valueOf(giftCertificate.getLastUpdateDate()));
            return ps;
        }, keyHolder);
        giftCertificate.setId(Objects.requireNonNull(keyHolder.getKey()).longValue());*/
        return giftCertificate;
    }

    @Override
    public List<GiftCertificate> findAll() {
        CriteriaQuery<GiftCertificate> criteriaQuery = criteriaBuilder.createQuery(GiftCertificate.class);
        Root<GiftCertificate> certificateRoot = criteriaQuery.from(GiftCertificate.class);
        criteriaQuery.select(certificateRoot);
        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    @Override
    public Optional<GiftCertificate> findById(Long id) {
        return Optional.ofNullable(entityManager.find(GiftCertificate.class, id));
    }

    @Override
    public int update(Long id, GiftCertificate giftCertificate) {
//        return jdbcTemplate.update(con -> {
//            PreparedStatement ps = con.prepareStatement(UPDATE_GIFT_CERTIFICATE);
//            ps.setString(1, giftCertificate.getName());
//            ps.setString(2, giftCertificate.getDescription());
//            ps.setBigDecimal(3, giftCertificate.getPrice());
//            ps.setInt(4, giftCertificate.getDuration());
//            ps.setTimestamp(5, Timestamp.valueOf(giftCertificate.getLastUpdateDate()));
//            ps.setLong(6, id);
//            return ps;
//        });
        return 0;
    }

    @Override
    public int deleteById(Long id) {
//        entityManager.detach();
//        return jdbcTemplate.update(DELETE_CERTIFICATE_BY_ID, id);
        return 0;
    }

    @Override
    public Set<Tag> setTagsToCertificate(Long id, Set<Tag> addedTags) {
        /*logger.info(addedTags);
        addedTags = addedTags.stream().map(tagDao::findOrCreate).collect(Collectors.toSet());
        for (Tag tag : addedTags){
            jdbcTemplate.update(SET_TAG_FOR_CERTIFICATE, id, tag.getId());
        }
        return addedTags;*/
        return new LinkedHashSet<>();
    }

    @Override
    public boolean removeAllTags(Long id) {
//        return jdbcTemplate.update(DELETE_ALL_TAGS_FROM_CERTIFICATE, id) > 0;
        return true;
    }

    @Override
    public List<GiftCertificate> findCertificatesByTagId(Long id) {
//        return jdbcTemplate.query(FIND_CERTIFICATE_BY_TAG, extractor, id);
        return new ArrayList<>();
    }
}
