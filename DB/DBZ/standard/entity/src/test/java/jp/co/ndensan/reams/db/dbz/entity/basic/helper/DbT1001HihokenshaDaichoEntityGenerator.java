/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.HihokenshashoSaikofuKubun;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.JushochitokureishaKubun;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.KoikinaiJushochitokureishaKubun;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShoriTimestamp;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.ur.urz.definition.valueobject.code.KaigoShikakuShutokuJiyu;
import jp.co.ndensan.reams.ur.urz.definition.valueobject.code.KaigoShikakuSoshitsuJiyu;
import jp.co.ndensan.reams.ur.urz.definition.valueobject.code.KaigoShikakuHenkoJiyu;
import jp.co.ndensan.reams.ur.urz.definition.valueobject.code.KaigoShikakuJutokuTekiyoJiyu;
import jp.co.ndensan.reams.ur.urz.definition.valueobject.code.KaigoShikakuJutokuKaijoJiyu;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 被保険者台帳エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author n8178 城間篤人
 */
public final class DbT1001HihokenshaDaichoEntityGenerator {

    public static final LasdecCode DEFAULT_市町村コード = new LasdecCode("202011");
    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo("0000000001");
    public static final ShoriTimestamp DEFAULT_処理日時 = ShoriTimestamp.of(new YMDHMS(new RString("20140415102030")));
    public static final ShikibetsuCode DEFAULT_識別コード = new ShikibetsuCode("000001234567890");
    public static final KaigoShikakuShutokuJiyu DEFAULT_資格取得事由コード = new KaigoShikakuShutokuJiyu(new Code("01"));
    public static final FlexibleDate DEFAULT_資格取得年月日 = new FlexibleDate("20140402");
    public static final FlexibleDate DEFAULT_資格取得届出年月日 = new FlexibleDate("20140402");
    public static final FlexibleDate DEFAULT_第1号資格取得年月日 = new FlexibleDate("20140402");
    public static final RString DEFAULT_被保険者区分コード = new RString("1");
    public static final KaigoShikakuSoshitsuJiyu DEFAULT_資格喪失事由コード = new KaigoShikakuSoshitsuJiyu(new Code("01"));
    public static final FlexibleDate DEFAULT_資格喪失年月日 = new FlexibleDate("20140402");
    public static final FlexibleDate DEFAULT_資格喪失届出年月日 = new FlexibleDate("20140402");
    public static final JushochitokureishaKubun DEFAULT_住所地特例フラグ = JushochitokureishaKubun.住所地特例者;
    public static final KaigoShikakuHenkoJiyu DEFAULT_資格変更事由コード = new KaigoShikakuHenkoJiyu(new Code("01"));
    public static final FlexibleDate DEFAULT_資格変更年月日 = new FlexibleDate("20140402");
    public static final FlexibleDate DEFAULT_資格変更届出年月日 = new FlexibleDate("20140402");
    public static final KaigoShikakuJutokuTekiyoJiyu DEFAULT_住所地特例適用事由コード = new KaigoShikakuJutokuTekiyoJiyu(new Code("00"));
    public static final FlexibleDate DEFAULT_適用年月日 = new FlexibleDate("20140402");
    public static final FlexibleDate DEFAULT_適用届出年月日 = new FlexibleDate("20140402");
    public static final KaigoShikakuJutokuKaijoJiyu DEFAULT_住所地特例解除事由コード = new KaigoShikakuJutokuKaijoJiyu(new Code("00"));
    public static final FlexibleDate DEFAULT_解除年月日 = new FlexibleDate("20140402");
    public static final FlexibleDate DEFAULT_解除届出年月日 = new FlexibleDate("20140402");
    public static final KoikinaiJushochitokureishaKubun DEFAULT_広域内住所地特例フラグ = KoikinaiJushochitokureishaKubun.広域内住所地特例者;
    public static final LasdecCode DEFAULT_広住特措置元市町村コード = new LasdecCode("000011");
    public static final LasdecCode DEFAULT_旧市町村コード = new LasdecCode("900010");
    public static final HihokenshashoSaikofuKubun DEFAULT_再交付区分 = HihokenshashoSaikofuKubun.あり;
    public static final RString DEFAULT_再交付事由コード = new RString("00");
    public static final RString DEFAULT_帳票交付履歴ID = new RString("1");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT1001HihokenshaDaichoEntityGenerator() {
    }

    public static DbT1001HihokenshaDaichoEntity createDbT1001HihokenshaDaichoEntity() {
        DbT1001HihokenshaDaichoEntity entity = new DbT1001HihokenshaDaichoEntity();
        entity.setShichosonCode(DEFAULT_市町村コード);
        entity.setHihokenshaNo(DEFAULT_被保険者番号);
        entity.setShoriTimestamp(DEFAULT_処理日時);
        entity.setShikibetsuCode(DEFAULT_識別コード);
        entity.setShikakuShutokuJiyuCode(DEFAULT_資格取得事由コード);
        entity.setShikakuShutokuYMD(DEFAULT_資格取得年月日);
        entity.setShikakuShutokuTodokedeYMD(DEFAULT_資格取得届出年月日);
        entity.setIchigoShikakuShutokuYMD(DEFAULT_第1号資格取得年月日);
        entity.setHihokennshaKubunCode(DEFAULT_被保険者区分コード);
        entity.setShikakuSoshitsuJiyuCode(DEFAULT_資格喪失事由コード);
        entity.setShikakuSoshitsuYMD(DEFAULT_資格喪失年月日);
        entity.setShikakuSoshitsuTodokedeYMD(DEFAULT_資格喪失届出年月日);
        entity.setJushochiTokureiFlag(DEFAULT_住所地特例フラグ.code());
        entity.setShikakuHenkoJiyuCode(DEFAULT_資格変更事由コード);
        entity.setShikakuHenkoYMD(DEFAULT_資格変更年月日);
        entity.setShikakuHenkoTodokedeYMD(DEFAULT_資格変更届出年月日);
        entity.setJushochitokureiTekiyoJiyuCode(DEFAULT_住所地特例適用事由コード);
        entity.setJushochitokureiTekiyoYMD(DEFAULT_適用年月日);
        entity.setJushochitokureiTekiyoTodokedeYMD(DEFAULT_適用届出年月日);
        entity.setJushochitokureiKaijoJiyuCode(DEFAULT_住所地特例解除事由コード);
        entity.setJushochitokureiKaijoYMD(DEFAULT_解除年月日);
        entity.setJushochitokureiKaijoTodokedeYMD(DEFAULT_解除届出年月日);
        entity.setKoikinaiJushochiTokureiFlag(DEFAULT_広域内住所地特例フラグ.getCode());
        entity.setKoikinaiTokureiSochimotoShichosonCode(DEFAULT_広住特措置元市町村コード);
        entity.setKyuShichosonCode(DEFAULT_旧市町村コード);
        entity.setSaikofuKubun(DEFAULT_再交付区分.getCode());
        entity.setSaikofuJiyuCode(DEFAULT_再交付事由コード);
        entity.setChohyoKofuRirekiID(DEFAULT_帳票交付履歴ID);
        return entity;
    }
}
