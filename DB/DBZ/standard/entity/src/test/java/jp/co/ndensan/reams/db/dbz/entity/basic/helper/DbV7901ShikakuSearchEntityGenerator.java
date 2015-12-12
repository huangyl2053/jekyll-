/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.kensaku.DbV7901ShikakuSearchEntity;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 資格検索Aliveエンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbV7901ShikakuSearchEntityGenerator {

    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo("0000000001");
    public static final RString DEFAULT_資格取得事由コード = new RString("Data");
    public static final FlexibleDate DEFAULT_資格取得年月日 = new FlexibleDate("19900101");
    public static final RString DEFAULT_被保険者区分コード = new RString("Data");
    public static final RString DEFAULT_資格喪失事由コード = new RString("Data");
    public static final FlexibleDate DEFAULT_資格喪失年月日 = new FlexibleDate("19900101");
    public static final RString DEFAULT_住所地特例フラグ = new RString("Data");
    public static final RString DEFAULT_資格変更事由コード = new RString("Data");
    public static final FlexibleDate DEFAULT_資格変更年月日 = new FlexibleDate("19900101");
    public static final RString DEFAULT_住所地特例適用事由コード = new RString("Data");
    public static final FlexibleDate DEFAULT_住所地特例適用年月日 = new FlexibleDate("19900101");
    public static final RString DEFAULT_住所地特例解除事由コード = new RString("Data");
    public static final FlexibleDate DEFAULT_住所地特例解除年月日 = new FlexibleDate("19900101");
    public static final RString DEFAULT_広域内住所地特例フラグ = new RString("Data");
    public static final LasdecCode DEFAULT_広住特措置元市町村コード = new LasdecCode("209007");
    public static final RString DEFAULT_適用除外適用事由コード = new RString("Data");
    public static final FlexibleDate DEFAULT_適用除外適用年月日 = new FlexibleDate("19900101");
    public static final RString DEFAULT_適用除外解除事由コード = new RString("Data");
    public static final FlexibleDate DEFAULT_適用除外解除年月日 = new FlexibleDate("19900101");
    public static final RString DEFAULT_他市町村住所地特例適用事由コード = new RString("Data");
    public static final FlexibleDate DEFAULT_他市町村住所地特例適用年月日 = new FlexibleDate("19900101");
    public static final RString DEFAULT_他市町村住所地特例解除事由コード = new RString("Data");
    public static final FlexibleDate DEFAULT_他市町村住所地特例解除年月日 = new FlexibleDate("19900101");
    public static final HihokenshaNo DEFAULT_受給者台帳被保険者番号 = new HihokenshaNo("0000000001");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbV7901ShikakuSearchEntityGenerator() {
    }

    public static DbV7901ShikakuSearchEntity createDbV7901ShikakuSearchEntity() {
        DbV7901ShikakuSearchEntity entity = new DbV7901ShikakuSearchEntity();
        entity.setHihokenshaNo(DEFAULT_被保険者番号);
        entity.setShikakuShutokuJiyuCode(DEFAULT_資格取得事由コード);
        entity.setShikakuShutokuYMD(DEFAULT_資格取得年月日);
        entity.setHihokennshaKubunCode(DEFAULT_被保険者区分コード);
        entity.setShikakuSoshitsuJiyuCode(DEFAULT_資格喪失事由コード);
        entity.setShikakuSoshitsuYMD(DEFAULT_資格喪失年月日);
        entity.setJushochiTokureiFlag(DEFAULT_住所地特例フラグ);
        entity.setShikakuHenkoJiyuCode(DEFAULT_資格変更事由コード);
        entity.setShikakuHenkoYMD(DEFAULT_資格変更年月日);
        entity.setJushochitokureiTekiyoJiyuCode(DEFAULT_住所地特例適用事由コード);
        entity.setJushochitokureiTekiyoYMD(DEFAULT_住所地特例適用年月日);
        entity.setJushochitokureiKaijoJiyuCode(DEFAULT_住所地特例解除事由コード);
        entity.setJushochitokureiKaijoYMD(DEFAULT_住所地特例解除年月日);
        entity.setKoikinaiJushochiTokureiFlag(DEFAULT_広域内住所地特例フラグ);
        entity.setKoikinaiTokureiSochimotoShichosonCode(DEFAULT_広住特措置元市町村コード);
        entity.setTekiyoJogaiTekiyoJiyuCode(DEFAULT_適用除外適用事由コード);
        entity.setTekiyoJogaiTekiyoYMD(DEFAULT_適用除外適用年月日);
        entity.setTekiyoJogaikaijokaijoJiyuCode(DEFAULT_適用除外解除事由コード);
        entity.setTekiyoJogaiKaijoYMD(DEFAULT_適用除外解除年月日);
        entity.setTatokureiTekiyoJiyuCode(DEFAULT_他市町村住所地特例適用事由コード);
        entity.setTatokureiTekiyoYMD(DEFAULT_他市町村住所地特例適用年月日);
        entity.setTatokureiKaijoJiyuCode(DEFAULT_他市町村住所地特例解除事由コード);
        entity.setTatokureiKaijoYMD(DEFAULT_他市町村住所地特例解除年月日);
        entity.setJukyushaDaichoHihokenshaNo(DEFAULT_受給者台帳被保険者番号);
        return entity;
    }
}
