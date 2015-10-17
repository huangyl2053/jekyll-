/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.entity.db.basic.helper;

import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7061JuryoIninKeiyakuJigyoshaEntity;
import jp.co.ndensan.reams.ua.uax.definition.core.valueobject.ServiceShubetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.KaigoJigyoshaNo;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 受領委任契約事業者エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT7061JuryoIninKeiyakuJigyoshaEntityGenerator {

    public static final KaigoJigyoshaNo DEFAULT_受領委任契約事業者番号 = new KaigoJigyoshaNo("0001");
    public static final FlexibleDate DEFAULT_受領委任契約開始日 = new FlexibleDate("19900101");
    public static final FlexibleDate DEFAULT_受領委任契約終了日 = new FlexibleDate("19900101");
    public static final ServiceShubetsuCode DEFAULT_契約サービス種別 = new ServiceShubetsuCode(new RString("Data"));
    public static final YubinNo DEFAULT_契約事業者郵便番号 = new YubinNo("0010001");
    public static final AtenaJusho DEFAULT_契約事業者住所 = new AtenaJusho("");
    public static final TelNo DEFAULT_契約事業者電話番号 = new TelNo("08011112222");
    public static final TelNo DEFAULT_契約事業者FAX番号 = new TelNo("08011112222");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT7061JuryoIninKeiyakuJigyoshaEntityGenerator() {
    }

    public static DbT7061JuryoIninKeiyakuJigyoshaEntity createDbT7061JuryoIninKeiyakuJigyoshaEntity() {
        DbT7061JuryoIninKeiyakuJigyoshaEntity entity = new DbT7061JuryoIninKeiyakuJigyoshaEntity();
        entity.setJigyoshaNo(DEFAULT_受領委任契約事業者番号);
        entity.setKeiyakuKaishiYMD(DEFAULT_受領委任契約開始日);
        entity.setKeiyakuShuryoYMD(DEFAULT_受領委任契約終了日);
        entity.setServiceShubetsuCode(DEFAULT_契約サービス種別);
        entity.setJigyoshaYubinNo(DEFAULT_契約事業者郵便番号);
        entity.setJigyoshaJusho(DEFAULT_契約事業者住所);
        entity.setJigyoshaTelNo(DEFAULT_契約事業者電話番号);
        entity.setJigyoshaFaxNo(DEFAULT_契約事業者FAX番号);
        return entity;
    }
}
