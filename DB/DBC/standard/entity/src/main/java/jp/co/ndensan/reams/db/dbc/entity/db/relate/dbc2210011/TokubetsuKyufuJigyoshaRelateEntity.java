/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc2210011;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3065ShichosonTokubetsuKyufuJigyoshaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3066ShichosonTokubetuKyufuServiceEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * TokubetsuKyufuJigyoshaEntityクラスです。
 *
 * @reamsid_L DBC-3430-010 miaojin
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TokubetsuKyufuJigyoshaRelateEntity implements Cloneable, Serializable {

    /**
     * -- GETTER -- 市町村特別給付サービス事業者Entityを返します。
     *
     * @return 市町村特別給付サービス事業者Entityを設定します。
     *
     * @param 市町村特別給付サービス事業者Entity 市町村特別給付サービス事業者Entity
     */
    private DbT3065ShichosonTokubetsuKyufuJigyoshaEntity 市町村特別給付サービス事業者Entity;

    /**
     * -- GETTER -- 市町村特別給付サービス内容Entityを返します。
     *
     * @return 市町村特別給付サービス内容Entityを設定します。
     *
     * @param 市町村特別給付サービス内容Entity 市町村特別給付サービス内容Entity
     */
    private DbT3066ShichosonTokubetuKyufuServiceEntity 市町村特別給付サービス内容Entity;

    /**
     * 介護国保連ＩＦ異動区分
     */
    private RString 介護国保連ＩＦ異動区分;

    /**
     * 介護国保連ＩＦ異動年月日
     */
    private FlexibleDate 介護国保連ＩＦ異動年月日;

    /**
     * 市町村特別給付用事業者番号
     */
    private JigyoshaNo 市町村特別給付用事業者番号;

    /**
     * 申請者氏名_漢字
     */
    private RString 申請者氏名_漢字;

    /**
     * 申請者住所
     */
    private RString 申請者住所;

    /**
     * 市町村特別給付用サービス名_略称
     */
    private RString 市町村特別給付用サービス名_略称;

    /**
     * コンストラクタです。
     */
    public TokubetsuKyufuJigyoshaRelateEntity() {
        市町村特別給付サービス事業者Entity = new DbT3065ShichosonTokubetsuKyufuJigyoshaEntity();
        市町村特別給付サービス内容Entity = new DbT3066ShichosonTokubetuKyufuServiceEntity();
    }

    /**
     * MyBatisで取得された場合に使用して下さい。<br/>
     * MyBatisで当クラス取得時は、新規追加(Added)となるため、変更無し(Unchanged)に設定します。<br/>
     * TokubetsuKyufuJigyoshaEntityが持つ{@link TokubetsuKyufuJigyoshaRelateEntity}<br/> {@link TokubetsuKyufuJigyoshaRelateEntity}のMD5値を計算し、設定します。
     */
    public void initializeMd5ToEntities() {
        this.市町村特別給付サービス事業者Entity.initializeMd5();
        this.市町村特別給付サービス内容Entity.initializeMd5();
    }
}
