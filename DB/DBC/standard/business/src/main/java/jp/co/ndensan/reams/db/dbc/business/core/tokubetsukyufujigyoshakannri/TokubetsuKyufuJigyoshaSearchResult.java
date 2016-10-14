/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.tokubetsukyufujigyoshakannri;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3065ShichosonTokubetsuKyufuJigyoshaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3066ShichosonTokubetuKyufuServiceEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc2210011.TokubetsuKyufuJigyoshaRelateEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 一覧を格納するビジネスクラスです。
 *
 * @reamsid_L DBC-3430-010 miaojin
 */
public class TokubetsuKyufuJigyoshaSearchResult implements Serializable {

    private final TokubetsuKyufuJigyoshaRelateEntity entity;

    /**
     * 一覧情報コンストラクタです。
     *
     * @param entity 一覧情報エンディディ
     */
    public TokubetsuKyufuJigyoshaSearchResult(TokubetsuKyufuJigyoshaRelateEntity entity) {
        this.entity = entity;
    }

    /**
     * 市町村特別給付サービス事業者Entityを取得する。
     *
     * @return 市町村特別給付サービス事業者Entity
     */
    public DbT3065ShichosonTokubetsuKyufuJigyoshaEntity get市町村特別給付サービス事業者Entity() {
        return entity.get市町村特別給付サービス事業者Entity();
    }

    /**
     * 市町村特別給付サービス内容Entityを取得する。
     *
     * @return 市町村特別給付サービス内容Entity
     */
    public DbT3066ShichosonTokubetuKyufuServiceEntity get市町村特別給付サービス内容Entity() {
        return entity.get市町村特別給付サービス内容Entity();
    }

    /**
     * 介護国保連ＩＦ異動区分を取得する。
     *
     * @return 介護国保連ＩＦ異動区分
     */
    public RString get介護国保連ＩＦ異動区分() {
        return entity.get市町村特別給付サービス事業者Entity().getIdoKubun();
    }

    /**
     * 介護国保連ＩＦ異動年月日を取得する。
     *
     * @return 介護国保連ＩＦ異動年月日
     */
    public FlexibleDate get介護国保連ＩＦ異動年月日() {
        return entity.get市町村特別給付サービス事業者Entity().getIdoYMD();
    }

    /**
     * 市町村特別給付用事業者番号を取得する。
     *
     * @return 市町村特別給付用事業者番号
     */
    public JigyoshaNo get市町村特別給付用事業者番号() {
        return entity.get市町村特別給付サービス事業者Entity().getJigyoshaNo();
    }

    /**
     * 申請者氏名_漢字を取得する。
     *
     * @return 申請者氏名_漢字
     */
    public RString get申請者氏名_漢字() {
        return entity.get市町村特別給付サービス事業者Entity().getShinseishaNameKanji();
    }

    /**
     * 申請者住所を取得する。
     *
     * @return 申請者住所
     */
    public RString get申請者住所() {
        return entity.get市町村特別給付サービス事業者Entity().getShinseishaAddressKanji();
    }

    /**
     * 市町村特別給付用サービス名_略称を取得する。
     *
     * @return 市町村特別給付用サービス名_略称
     */
    public RString get市町村特別給付用サービス名_略称() {
        return entity.get市町村特別給付サービス内容Entity().getServiceRyakushoName();
    }
}
