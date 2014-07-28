/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.mapper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.KyotakuServiceSeikyuKingakuJoho;
import jp.co.ndensan.reams.db.dbc.business.KyufuJissekiKyotakuService;
import jp.co.ndensan.reams.db.dbc.business.KyufuJissekiKyotakuServiceList;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3025KyufujissekiKyotakuServiceEntity;

/**
 * 給付実績居宅サービスのマッピングを行うクラスです。
 *
 * @author n8178 城間篤人
 */
public final class KyufuJissekiKyotakuServiceMapper {

    /**
     * インスタンス化防止のためのプライベートコンストラクタです。
     */
    private KyufuJissekiKyotakuServiceMapper() {

    }

    /**
     * 給付実績居宅サービスを受け取り、Entityにマッピングして返します。
     *
     * @param 給付実績居宅サービス 給付実績居宅サービス
     * @return 給付実績居宅サービスEntity
     */
    public static DbT3025KyufujissekiKyotakuServiceEntity to給付実績居宅サービスEntity(
            KyufuJissekiKyotakuService 給付実績居宅サービス) {
        if (給付実績居宅サービス == null) {
            return null;
        }

        DbT3025KyufujissekiKyotakuServiceEntity entity = new DbT3025KyufujissekiKyotakuServiceEntity();
        entity.setKokanJohoShikibetsuNo(給付実績居宅サービス.get交換情報識別コード());
        entity.setInputShikibetsuNo(給付実績居宅サービス.get入力識別コード());
        entity.setRecodeShubetsuCode(給付実績居宅サービス.getレコード種別コード());
        entity.setShokisaiHokenshaNo(給付実績居宅サービス.get証記載保険者番号());
        entity.setHiHokenshaNo(給付実績居宅サービス.get被保険者番号());
        entity.setServiceTeikyoYM(給付実績居宅サービス.getサービス適用年月());
        entity.setJigyoshoNo(給付実績居宅サービス.get事業者番号());
        entity.setToshiNo(給付実績居宅サービス.get通し番号());
        entity.setShiteiKijunGaitoJigyoshaKubunCode(給付実績居宅サービス.get指定基準該当等事業者区分コード());
        entity.setTanisuTanka(給付実績居宅サービス.get単位数単価());
        entity.setKyotakuServiceSakuseiIraiYMD(給付実績居宅サービス.get居宅サービス作成依頼年月日());
        entity.setServicePlanhiMeisaiLineNo(給付実績居宅サービス.getサービス計画費明細行番号());
        entity.setServiceCode(給付実績居宅サービス.getサービスコード());
        entity.setTanisu(給付実績居宅サービス.get請求金額情報().get単位数());
        entity.setKaisu(給付実績居宅サービス.get請求金額情報().get回数());
        entity.setServiceTanisu(給付実績居宅サービス.get請求金額情報().getサービス単位数());
        entity.setServiceTanisuTotal(給付実績居宅サービス.get請求金額情報().getサービス単位数合計());
        entity.setSeikyuKingaku(給付実績居宅サービス.get請求金額情報().get請求金額());
        entity.setTantouKaigoShienSemmoninNo(給付実績居宅サービス.get担当介護支援専門員番号());
        entity.setTekiyo(給付実績居宅サービス.get摘要());
        entity.setAtoTanisu(給付実績居宅サービス.get後請求金額情報().get単位数());
        entity.setAtoKaisu(給付実績居宅サービス.get後請求金額情報().get回数());
        entity.setAtoServiceTanisu(給付実績居宅サービス.get後請求金額情報().getサービス単位数());
        entity.setAtoServiceTanisuTotal(給付実績居宅サービス.get後請求金額情報().getサービス単位数合計());
        entity.setAtoSeikyuKingaku(給付実績居宅サービス.get後請求金額情報().get請求金額());
        entity.setSaishinsaKaisu(給付実績居宅サービス.get再審査回数());
        entity.setKagoKaisu(給付実績居宅サービス.get過誤回数());
        entity.setShinsaYM(給付実績居宅サービス.get審査年月());
        entity.setSeiriNo(給付実績居宅サービス.get整理番号());
        entity.setTorikomiYM(給付実績居宅サービス.get取込年月());
        return entity;
    }

    /**
     * 給付実績居宅サービスのListを受け取り、EntityのListにマッピングして返します。<br/>
     * nullが渡されると空のリストを返します。
     *
     * @param 給付実績居宅サービスList 給付実績居宅サービスList
     * @return 給付実績居宅サービスEntityList
     */
    public static List<DbT3025KyufujissekiKyotakuServiceEntity> to給付実績居宅サービスEntityList(
            KyufuJissekiKyotakuServiceList 給付実績居宅サービスList) {
        if (給付実績居宅サービスList == null) {
            return Collections.<DbT3025KyufujissekiKyotakuServiceEntity>emptyList();
        }

        List<DbT3025KyufujissekiKyotakuServiceEntity> entityList = new ArrayList<>();
        for (KyufuJissekiKyotakuService 給付実績居宅サービス : 給付実績居宅サービスList) {
            entityList.add(to給付実績居宅サービスEntity(給付実績居宅サービス));
        }
        return entityList;
    }

    /**
     * 給付実績居宅サービスのEntityを受け取り、給付実績居宅サービスにマッピングして返します。<br/>
     * 引数にnullが渡されている場合、nullを返します。
     *
     * @param entity 給付実績居宅サービスのEntity
     * @return 給付実績居宅サービス
     */
    public static KyufuJissekiKyotakuService to給付実績居宅サービス(DbT3025KyufujissekiKyotakuServiceEntity entity) {
        if (entity == null) {
            return null;
        }

        return new KyufuJissekiKyotakuService(
                entity.getKokanJohoShikibetsuNo(),
                entity.getInputShikibetsuNo(),
                entity.getRecodeShubetsuCode(),
                entity.getShokisaiHokenshaNo(),
                entity.getHiHokenshaNo(),
                entity.getServiceTeikyoYM(),
                entity.getJigyoshoNo(),
                entity.getToshiNo(),
                entity.getShiteiKijunGaitoJigyoshaKubunCode(),
                entity.getKyotakuServiceSakuseiIraiYMD(),
                entity.getServicePlanhiMeisaiLineNo(),
                entity.getTanisuTanka(),
                entity.getServiceCode(),
                new KyotakuServiceSeikyuKingakuJoho(entity.getTanisu(), entity.getKaisu(),
                        entity.getServiceTanisu(), entity.getServiceTanisuTotal(), entity.getSeikyuKingaku()),
                entity.getTantouKaigoShienSemmoninNo(),
                entity.getTekiyo(),
                new KyotakuServiceSeikyuKingakuJoho(entity.getAtoTanisu(), entity.getAtoKaisu(),
                        entity.getAtoServiceTanisu(), entity.getAtoServiceTanisuTotal(), entity.getAtoSeikyuKingaku()),
                entity.getSaishinsaKaisu(),
                entity.getKagoKaisu(),
                entity.getShinsaYM(),
                entity.getSeiriNo(),
                entity.getTorikomiYM()
        );
    }

    /**
     * 給付実績居宅サービスEntityのListを受け取り、給付実績居宅サービスListにマッピングして返します。<br/>
     * nullが渡された場合、空のListを返します。
     *
     * @param entityList 給付実績居宅サービスEntityList
     * @return 給付実績居宅サービスList
     */
    public static KyufuJissekiKyotakuServiceList to給付実績居宅サービスList(List<DbT3025KyufujissekiKyotakuServiceEntity> entityList) {
        if (entityList == null) {
            return new KyufuJissekiKyotakuServiceList(Collections.<KyufuJissekiKyotakuService>emptyList());
        }

        List<KyufuJissekiKyotakuService> 給付実績居宅サービスList = new ArrayList<>();
        for (DbT3025KyufujissekiKyotakuServiceEntity entity : entityList) {
            給付実績居宅サービスList.add(to給付実績居宅サービス(entity));
        }
        return new KyufuJissekiKyotakuServiceList(給付実績居宅サービスList);
    }
}
