/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1011TenshutsuHoryuTaishoshaEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaBanchi;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Katagaki;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.ZenkokuJushoCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 転出保留対象者エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT1011TenshutsuHoryuTaishoshaEntityGenerator {

    public static final ShikibetsuCode DEFAULT_識別コード = new ShikibetsuCode("012340123400001");
    public static final Decimal DEFAULT_履歴番号 = new Decimal(0);
    public static final LasdecCode DEFAULT_市町村コード = new LasdecCode("209007");
    public static final RString DEFAULT_作成事由コード = new RString("Data");
    public static final SetaiCode DEFAULT_世帯コード = new SetaiCode("012340123400001");
    public static final RString DEFAULT_住民種別コード = new RString("Data");
    public static final RString DEFAULT_住民状態コード = new RString("Data");
    public static final AtenaMeisho DEFAULT_宛名氏名 = new AtenaMeisho("");
    public static final AtenaKanaMeisho DEFAULT_宛名カナ氏名 = new AtenaKanaMeisho("");
    public static final FlexibleDate DEFAULT_生年月日 = new FlexibleDate("19900101");
    public static final RString DEFAULT_性別コード = new RString("Data");
    public static final RString DEFAULT_異動事由コード = new RString("Data");
    public static final FlexibleDate DEFAULT_登録異動年月日 = new FlexibleDate("19900101");
    public static final FlexibleDate DEFAULT_登録異動届出年月日 = new FlexibleDate("19900101");
    public static final FlexibleDate DEFAULT_消除異動年月日 = new FlexibleDate("19900101");
    public static final FlexibleDate DEFAULT_消除異動届出年月日 = new FlexibleDate("19900101");
    public static final FlexibleDate DEFAULT_転出予定異動年月日 = new FlexibleDate("19900101");
    public static final FlexibleDate DEFAULT_転出確定異動年月日 = new FlexibleDate("19900101");
    public static final FlexibleDate DEFAULT_転出確定異動通知年月日 = new FlexibleDate("19900101");
    public static final RString DEFAULT_全国住所コード = new RString("Data");
    public static final AtenaJusho DEFAULT_住所 = new AtenaJusho("");
    public static final AtenaBanchi DEFAULT_番地 = new AtenaBanchi("");
    public static final Katagaki DEFAULT_方書 = new Katagaki("肩書き");
    public static final ZenkokuJushoCode DEFAULT_転出予定全国住所コード = new ZenkokuJushoCode("00100010001");
    public static final AtenaJusho DEFAULT_転出予定住所 = new AtenaJusho("");
    public static final AtenaBanchi DEFAULT_転出予定番地 = new AtenaBanchi("");
    public static final Katagaki DEFAULT_転出予定方書 = new Katagaki("肩書き");
    public static final ZenkokuJushoCode DEFAULT_転出確定全国住所コード = new ZenkokuJushoCode("00100010001");
    public static final AtenaJusho DEFAULT_転出確定住所 = new AtenaJusho("");
    public static final AtenaBanchi DEFAULT_転出確定番地 = new AtenaBanchi("");
    public static final Katagaki DEFAULT_転出確定方書 = new Katagaki("肩書き");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT1011TenshutsuHoryuTaishoshaEntityGenerator() {
    }

    public static DbT1011TenshutsuHoryuTaishoshaEntity createDbT1011TenshutsuHoryuTaishoshaEntity() {
        DbT1011TenshutsuHoryuTaishoshaEntity entity = new DbT1011TenshutsuHoryuTaishoshaEntity();
        entity.setShikibetsuCode(DEFAULT_識別コード);
        entity.setRirekiNo(DEFAULT_履歴番号);
        entity.setShichosonCode(DEFAULT_市町村コード);
        entity.setSakuseiJiyuCode(DEFAULT_作成事由コード);
        entity.setSetaiCode(DEFAULT_世帯コード);
        entity.setJuminShubetsuCode(DEFAULT_住民種別コード);
        entity.setJuminJotaiCode(DEFAULT_住民状態コード);
        entity.setAtenaShimei(DEFAULT_宛名氏名);
        entity.setAtenaKanaShimei(DEFAULT_宛名カナ氏名);
        entity.setSeinengappiYMD(DEFAULT_生年月日);
        entity.setSeibetsuCode(DEFAULT_性別コード);
        entity.setIdoJiyuCode(DEFAULT_異動事由コード);
        entity.setTorokuIdoYMD(DEFAULT_登録異動年月日);
        entity.setTorokuTodokedeYMD(DEFAULT_登録異動届出年月日);
        entity.setShojoIdoYMD(DEFAULT_消除異動年月日);
        entity.setShojoTodokedeYMD(DEFAULT_消除異動届出年月日);
        entity.setTenshutsuYoteiIdoYMD(DEFAULT_転出予定異動年月日);
        entity.setTenshutsuKakuteiIdoYMD(DEFAULT_転出確定異動年月日);
        entity.setTenshutsuKakuteiTsuchiYMD(DEFAULT_転出確定異動通知年月日);
        entity.setZenkokuJushoCode(DEFAULT_全国住所コード);
        entity.setJusho(DEFAULT_住所);
        entity.setBanchi(DEFAULT_番地);
        entity.setKatagaki(DEFAULT_方書);
        entity.setTenshutsuYoteiZenkokuJushoCode(DEFAULT_転出予定全国住所コード);
        entity.setTenshutsuYoteiJusho(DEFAULT_転出予定住所);
        entity.setTenshutsuYoteiBanchi(DEFAULT_転出予定番地);
        entity.setTenshutsuYoteiKatagaki(DEFAULT_転出予定方書);
        entity.setTenshutsuKakuteiZenkokuJushoCode(DEFAULT_転出確定全国住所コード);
        entity.setTenshutsuKakuteiJusho(DEFAULT_転出確定住所);
        entity.setTenshutsuKakuteiBanchi(DEFAULT_転出確定番地);
        entity.setTenshutsuKakuteiKatagaki(DEFAULT_転出確定方書);
        return entity;
    }
}
