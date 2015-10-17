/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.basic.helper;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3077JuryoininKeiyakuJigyoshaEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanCode;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanShitenCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 受領委任契約事業者エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT3077JuryoininKeiyakuJigyoshaEntityGenerator {

    public static final RString DEFAULT_事業者契約番号 = new RString("Data");
    public static final FlexibleDate DEFAULT_開始年月日 = new FlexibleDate("19900101");
    public static final Decimal DEFAULT_履歴番号 = new Decimal(0);
    public static final FlexibleDate DEFAULT_終了年月日 = new FlexibleDate("19900101");
    public static final FlexibleDate DEFAULT_届出年月日 = new FlexibleDate("19900101");
    public static final RString DEFAULT_届出者住所 = new RString("Data");
    public static final RString DEFAULT_届出者事業者名称 = new RString("Data");
    public static final RString DEFAULT_届出者代表者氏名 = new RString("Data");
    public static final KinyuKikanCode DEFAULT_金融機関コード = new KinyuKikanCode("0001");
    public static final KinyuKikanShitenCode DEFAULT_支店コード = new KinyuKikanShitenCode("001");
    public static final RString DEFAULT_口座種別 = new RString("Data");
    public static final RString DEFAULT_口座番号 = new RString("Data");
    public static final RString DEFAULT_通帳記号 = new RString("Data");
    public static final RString DEFAULT_通帳番号 = new RString("Data");
    public static final AtenaKanaMeisho DEFAULT_口座名義人 = new AtenaKanaMeisho("");
    public static final AtenaMeisho DEFAULT_口座名義人漢字 = new AtenaMeisho("");
    public static final TelNo DEFAULT_事業者FAX番号 = new TelNo("08011112222");
    public static final FlexibleDate DEFAULT_契約登録年月日 = new FlexibleDate("19900101");
    public static final RString DEFAULT_送付先部署 = new RString("Data");
    public static final RString DEFAULT_営業形態 = new RString("Data");
    public static final boolean DEFAULT_住宅改修契約有無 = false;
    public static final boolean DEFAULT_特定福祉用具販売契約有無 = false;
    public static final boolean DEFAULT_償還払給付契約有無 = false;
    public static final boolean DEFAULT_高額給付契約有無 = false;
    public static final JigyoshaNo DEFAULT_契約事業者番号 = new JigyoshaNo("1");
    public static final boolean DEFAULT_取扱確約書有無 = false;

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3077JuryoininKeiyakuJigyoshaEntityGenerator() {
    }

    public static DbT3077JuryoininKeiyakuJigyoshaEntity createDbT3077JuryoininKeiyakuJigyoshaEntity() {
        DbT3077JuryoininKeiyakuJigyoshaEntity entity = new DbT3077JuryoininKeiyakuJigyoshaEntity();
        entity.setJigyoshaKeiyakuNo(DEFAULT_事業者契約番号);
        entity.setKaishiYMD(DEFAULT_開始年月日);
        entity.setRirekiNo(DEFAULT_履歴番号);
        entity.setShuryoYMD(DEFAULT_終了年月日);
        entity.setTodokedeYMD(DEFAULT_届出年月日);
        entity.setTodokedeAddress(DEFAULT_届出者住所);
        entity.setTodokedeJigyoshaName(DEFAULT_届出者事業者名称);
        entity.setTodokedeDaihyoshaName(DEFAULT_届出者代表者氏名);
        entity.setKinyuKikanCode(DEFAULT_金融機関コード);
        entity.setShitenCode(DEFAULT_支店コード);
        entity.setKozaShubetsu(DEFAULT_口座種別);
        entity.setKozaNo(DEFAULT_口座番号);
        entity.setTsuchoKigo(DEFAULT_通帳記号);
        entity.setTsuchoNo(DEFAULT_通帳番号);
        entity.setKozaMeiginin(DEFAULT_口座名義人);
        entity.setKozaMeigininKanji(DEFAULT_口座名義人漢字);
        entity.setJigyoshaFaxNo(DEFAULT_事業者FAX番号);
        entity.setKeiyakuTorokuYMD(DEFAULT_契約登録年月日);
        entity.setSofusakiBusho(DEFAULT_送付先部署);
        entity.setEigyoKeitai(DEFAULT_営業形態);
        entity.setJutakuKaishuKeiyakuUmu(DEFAULT_住宅改修契約有無);
        entity.setTokuteiFukushiYoguHanbaiKeiyakuUmu(DEFAULT_特定福祉用具販売契約有無);
        entity.setShokanbaraiKyufuKeiyakuUmu(DEFAULT_償還払給付契約有無);
        entity.setKogakuKyufuKeiyakuUmu(DEFAULT_高額給付契約有無);
        entity.setKeiyakuJigyoshaNo(DEFAULT_契約事業者番号);
        entity.setToriatsukaiKakuyakushoUmu(DEFAULT_取扱確約書有無);
        return entity;
    }
}
