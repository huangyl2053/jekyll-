/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 被保険者台帳管理エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT1001HihokenshaDaichoEntityGenerator {

    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo("1");
    public static final FlexibleDate DEFAULT_異動日 = new FlexibleDate("19900101");
    public static final RString DEFAULT_枝番 = new RString("Data");
    public static final RString DEFAULT_異動事由コード = new RString("Data");
    public static final LasdecCode DEFAULT_市町村コード = new LasdecCode("209007");
    public static final ShikibetsuCode DEFAULT_識別コード = new ShikibetsuCode("012340123400001");
    public static final RString DEFAULT_資格取得事由コード = new RString("Data");
    public static final FlexibleDate DEFAULT_資格取得年月日 = new FlexibleDate("19900101");
    public static final FlexibleDate DEFAULT_資格取得届出年月日 = new FlexibleDate("19900101");
    public static final FlexibleDate DEFAULT_第1号資格取得年月日 = new FlexibleDate("19900101");
    public static final RString DEFAULT_被保険者区分コード = new RString("Data");
    public static final RString DEFAULT_資格喪失事由コード = new RString("Data");
    public static final FlexibleDate DEFAULT_資格喪失年月日 = new FlexibleDate("19900101");
    public static final FlexibleDate DEFAULT_資格喪失届出年月日 = new FlexibleDate("19900101");
    public static final RString DEFAULT_資格変更事由コード = new RString("Data");
    public static final FlexibleDate DEFAULT_資格変更年月日 = new FlexibleDate("19900101");
    public static final FlexibleDate DEFAULT_資格変更届出年月日 = new FlexibleDate("19900101");
    public static final RString DEFAULT_住所地特例適用事由コード = new RString("Data");
    public static final FlexibleDate DEFAULT_適用年月日 = new FlexibleDate("19900101");
    public static final FlexibleDate DEFAULT_適用届出年月日 = new FlexibleDate("19900101");
    public static final RString DEFAULT_住所地特例解除事由コード = new RString("Data");
    public static final FlexibleDate DEFAULT_解除年月日 = new FlexibleDate("19900101");
    public static final FlexibleDate DEFAULT_解除届出年月日 = new FlexibleDate("19900101");
    public static final RString DEFAULT_住所地特例フラグ = new RString("Data");
    public static final RString DEFAULT_広域内住所地特例フラグ = new RString("Data");
    public static final LasdecCode DEFAULT_広住特措置元市町村コード = new LasdecCode("209007");
    public static final LasdecCode DEFAULT_旧市町村コード = new LasdecCode("209007");
    public static final boolean DEFAULT_論理削除フラグ = false;

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT1001HihokenshaDaichoEntityGenerator() {
    }

    public static DbT1001HihokenshaDaichoEntity createDbT1001HihokenshaDaichoEntity() {
        DbT1001HihokenshaDaichoEntity entity = new DbT1001HihokenshaDaichoEntity();
        entity.setHihokenshaNo(DEFAULT_被保険者番号);
        entity.setIdoYMD(DEFAULT_異動日);
        entity.setEdaNo(DEFAULT_枝番);
        entity.setIdoJiyuCode(DEFAULT_異動事由コード);
        entity.setShichosonCode(DEFAULT_市町村コード);
        entity.setShikibetsuCode(DEFAULT_識別コード);
        entity.setShikakuShutokuJiyuCode(DEFAULT_資格取得事由コード);
        entity.setShikakuShutokuYMD(DEFAULT_資格取得年月日);
        entity.setShikakuShutokuTodokedeYMD(DEFAULT_資格取得届出年月日);
        entity.setIchigoShikakuShutokuYMD(DEFAULT_第1号資格取得年月日);
        entity.setHihokennshaKubunCode(DEFAULT_被保険者区分コード);
        entity.setShikakuSoshitsuJiyuCode(DEFAULT_資格喪失事由コード);
        entity.setShikakuSoshitsuYMD(DEFAULT_資格喪失年月日);
        entity.setShikakuSoshitsuTodokedeYMD(DEFAULT_資格喪失届出年月日);
        entity.setShikakuHenkoJiyuCode(DEFAULT_資格変更事由コード);
        entity.setShikakuHenkoYMD(DEFAULT_資格変更年月日);
        entity.setShikakuHenkoTodokedeYMD(DEFAULT_資格変更届出年月日);
        entity.setJushochitokureiTekiyoJiyuCode(DEFAULT_住所地特例適用事由コード);
        entity.setJushochitokureiTekiyoYMD(DEFAULT_適用年月日);
        entity.setJushochitokureiTekiyoTodokedeYMD(DEFAULT_適用届出年月日);
        entity.setJushochitokureiKaijoJiyuCode(DEFAULT_住所地特例解除事由コード);
        entity.setJushochitokureiKaijoYMD(DEFAULT_解除年月日);
        entity.setJushochitokureiKaijoTodokedeYMD(DEFAULT_解除届出年月日);
        entity.setJushochiTokureiFlag(DEFAULT_住所地特例フラグ);
        entity.setKoikinaiJushochiTokureiFlag(DEFAULT_広域内住所地特例フラグ);
        entity.setKoikinaiTokureiSochimotoShichosonCode(DEFAULT_広住特措置元市町村コード);
        entity.setKyuShichosonCode(DEFAULT_旧市町村コード);
        entity.setLogicalDeletedFlag(DEFAULT_論理削除フラグ);
        return entity;
    }
}
