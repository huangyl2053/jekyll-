/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.entity.db.basic.helper;

import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7061JuryoIninJigyoshaEntity;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 受領委任契約事業者エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT7061JuryoIninJigyoshaEntityGenerator {

    public static final JigyoshaNo DEFAULT_受領委任契約事業者番号 = new JigyoshaNo("0001");
    public static final FlexibleDate DEFAULT_受領委任契約開始日 = new FlexibleDate("19900101");
    public static final FlexibleDate DEFAULT_受領委任契約終了日 = new FlexibleDate("19900101");
    public static final RString DEFAULT_契約サービス種別 = new RString("Data");
    public static final YubinNo DEFAULT_契約事業者郵便番号 = new YubinNo("0010001");
    public static final AtenaJusho DEFAULT_契約事業者住所 = new AtenaJusho("");
    public static final TelNo DEFAULT_契約事業者電話番号 = new TelNo("08011112222");
    public static final TelNo DEFAULT_契約事業者FAX番号 = new TelNo("08011112222");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT7061JuryoIninJigyoshaEntityGenerator() {
    }

    public static DbT7061JuryoIninJigyoshaEntity createDbT7061JuryoIninJigyoshaEntity() {
        DbT7061JuryoIninJigyoshaEntity entity = new DbT7061JuryoIninJigyoshaEntity();
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
