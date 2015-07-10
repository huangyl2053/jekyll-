/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3056KogakuShikyuShinseiEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 高額介護サービス費支給申請エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author LDNS 周杏月
 */
public final class DbT3056KogakuShikyuShinseiEntityGenerator {

    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo(new RString("2"));
    public static final FlexibleYearMonth DEFAULT_サービス提供年月 = new FlexibleYearMonth(new RString("201406"));
    public static final HokenshaNo DEFAULT_証記載保険者番号 = new HokenshaNo(new RString("2"));
    public static final YMDHMS DEFAULT_処理日時 = new YMDHMS(new RString("20140415102030"));
    public static final FlexibleDate DEFAULT_受付年月日 = new FlexibleDate("20140402");
    public static final FlexibleDate DEFAULT_申請年月日 = new FlexibleDate("20140402");
    public static final RString DEFAULT_申請理由 = new RString("1");
    public static final RString DEFAULT_申請者区分 = new RString("1");
    public static final AtenaMeisho DEFAULT_申請者氏名 = new AtenaMeisho("電算太郎");
    public static final AtenaKanaMeisho DEFAULT_申請者氏名カナ = new AtenaKanaMeisho("デンサンタロウ");
    public static final RString DEFAULT_申請者住所 = new RString("1");
    public static final TelNo DEFAULT_申請者電話番号 = new TelNo("012-345-6789");
    public static final JigyoshaNo DEFAULT_申請事業者番号 = new JigyoshaNo(new RString("2"));

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3056KogakuShikyuShinseiEntityGenerator() {
    }

    public static DbT3056KogakuShikyuShinseiEntity createDbT3056KogakuShikyuShinseiEntity() {
        DbT3056KogakuShikyuShinseiEntity entity = new DbT3056KogakuShikyuShinseiEntity();
        entity.setHihokenshaNo(DEFAULT_被保険者番号);
        entity.setServiceTeikyoYM(DEFAULT_サービス提供年月);
        entity.setShoKisaiHokenshaNo(DEFAULT_証記載保険者番号);
        entity.setShoriTimestamp(DEFAULT_処理日時);
        entity.setUketsukeYMD(DEFAULT_受付年月日);
        entity.setShinseiYMD(DEFAULT_申請年月日);
        entity.setShinseiRiyu(DEFAULT_申請理由);
        entity.setShinseishaKubun(DEFAULT_申請者区分);
        entity.setShinseishaShimei(DEFAULT_申請者氏名);
        entity.setShinseishaShimeiKana(DEFAULT_申請者氏名カナ);
        entity.setShinseishaJusho(DEFAULT_申請者住所);
        entity.setShinseishaTelNo(DEFAULT_申請者電話番号);
        entity.setShinseiJigyoshaNo(DEFAULT_申請事業者番号);
        return entity;
    }
}
