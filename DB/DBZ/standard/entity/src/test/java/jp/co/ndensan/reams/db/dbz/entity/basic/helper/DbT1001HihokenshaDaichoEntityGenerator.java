/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.ur.urz.definition.Messages;
import jp.co.ndensan.reams.ur.urz.definition.valueobject.code.KaigoshikakuHenkoJiyuHihokensha;
import jp.co.ndensan.reams.ur.urz.definition.valueobject.code.KaigoshikakuJutokuKaijo;
import jp.co.ndensan.reams.ur.urz.definition.valueobject.code.KaigoshikakuShutokuJiyuHihokensha;
import jp.co.ndensan.reams.ur.urz.definition.valueobject.code.KaigoshikakuSoshitsuJiyuHihokennsha;
import jp.co.ndensan.reams.ur.urz.definition.valueobject.code.KaigoshikakuJutokuTekiyo;
import jp.co.ndensan.reams.ur.urz.definition.valueobject.code.KofuJiyu;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 被保険者台帳エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author n8178 城間篤人
 */
public final class DbT1001HihokenshaDaichoEntityGenerator {

    public static final LasdecCode DEFAULT_市町村コード = new LasdecCode("000010");
    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo("0000100001");
    public static final YMDHMS DEFAULT_処理日時 = new YMDHMS("20141209123456");
    public static final ShikibetsuCode DEFAULT_識別コード = new ShikibetsuCode("000010000100001");
    public static final KaigoshikakuShutokuJiyuHihokensha DEFAULT_資格取得事由コード = new KaigoshikakuShutokuJiyuHihokensha(new Code("01"));
    public static final FlexibleDate DEFAULT_資格取得年月日 = new FlexibleDate("20141209");
    public static final FlexibleDate DEFAULT_資格取得届出年月日 = new FlexibleDate("20141209");
    public static final FlexibleDate DEFAULT_第1号被保険者年齢到達年月日 = new FlexibleDate("20141208");
    public static final Code DEFAULT_被保険者区分コード = new Code("1");
    public static final KaigoshikakuSoshitsuJiyuHihokennsha DEFAULT_資格喪失事由コード = new KaigoshikakuSoshitsuJiyuHihokennsha(new Code("51"));
    public static final FlexibleDate DEFAULT_資格喪失年月日 = new FlexibleDate("20160618");
    public static final FlexibleDate DEFAULT_資格喪失届出年月日 = new FlexibleDate("20160618");
    public static final RString DEFAULT_住所地特例フラグ = new RString("1");
    public static final KaigoshikakuHenkoJiyuHihokensha DEFAULT_資格変更事由コード = new KaigoshikakuHenkoJiyuHihokensha(new Code("01"));
    public static final FlexibleDate DEFAULT_資格変更年月日 = new FlexibleDate("20150707");
    public static final FlexibleDate DEFAULT_資格変更届出年月日 = new FlexibleDate("20150707");
    public static final KaigoshikakuJutokuTekiyo DEFAULT_住所地特例適用事由コード = new KaigoshikakuJutokuTekiyo(new Code("01"));
    public static final FlexibleDate DEFAULT_適用年月日 = new FlexibleDate("20150302");
    public static final FlexibleDate DEFAULT_適用届出年月日 = new FlexibleDate("20150302");
    public static final KaigoshikakuJutokuKaijo DEFAULT_住所地特例解除事由コード = new KaigoshikakuJutokuKaijo(new Code("01"));
    public static final FlexibleDate DEFAULT_解除年月日 = new FlexibleDate("20150525");
    public static final FlexibleDate DEFAULT_解除届出年月日 = new FlexibleDate("20150525");
    public static final RString DEFAULT_広域内住所地特例フラグ = new RString("1");
    public static final LasdecCode DEFAULT_広住特措置元市町村コード = new LasdecCode("000011");
    public static final LasdecCode DEFAULT_旧市町村コード = new LasdecCode("900010");
    public static final RString DEFAULT_再交付区分 = new RString("1");
    public static final KofuJiyu DEFAULT_再交付事由コード = new KofuJiyu(new Code("1"));
    public static final RString DEFAULT_帳票交付履歴ID = new RString("0000100001");

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
        entity.setIchigoShikakuShutokuYMD(DEFAULT_第1号被保険者年齢到達年月日);
        entity.setHihokennshaKubunCode(DEFAULT_被保険者区分コード);
        entity.setShikakuSoshitsuJiyuCode(DEFAULT_資格喪失事由コード);
        entity.setShikakuSoshitsuYMD(DEFAULT_資格喪失年月日);
        entity.setShikakuSoshitsuTodokedeYMD(DEFAULT_資格喪失届出年月日);
        entity.setJushochiTokureiFlag(DEFAULT_住所地特例フラグ);
        entity.setShikakuHenkoJiyuCode(DEFAULT_資格変更事由コード);
        entity.setShikakuHenkoYMD(DEFAULT_資格変更年月日);
        entity.setShikakuHenkoTodokedeYMD(DEFAULT_資格変更届出年月日);
        entity.setJushochitokureiTekiyoJiyuCode(DEFAULT_住所地特例適用事由コード);
        entity.setJushochitokureiTekiyoYMD(DEFAULT_適用年月日);
        entity.setJushochitokureiTekiyoTodokedeYMD(DEFAULT_適用届出年月日);
        entity.setJushochitokureiKaijoJiyuCode(DEFAULT_住所地特例解除事由コード);
        entity.setJushochitokureiKaijoYMD(DEFAULT_解除年月日);
        entity.setJushochitokureiKaijoTodokedeYMD(DEFAULT_解除届出年月日);
        entity.setKoikinaiJushochiTokureiFlag(DEFAULT_広域内住所地特例フラグ);
        entity.setKoikinaiTokureiSochimotoShichosonCode(DEFAULT_広住特措置元市町村コード);
        entity.setKyuShichosonCode(DEFAULT_旧市町村コード);
        entity.setSaikofuKubun(DEFAULT_再交付区分);
        entity.setSaikofuJiyuCode(DEFAULT_再交付事由コード);
        entity.setChohyoKofuRirekiID(DEFAULT_帳票交付履歴ID);
        return entity;
    }
}
