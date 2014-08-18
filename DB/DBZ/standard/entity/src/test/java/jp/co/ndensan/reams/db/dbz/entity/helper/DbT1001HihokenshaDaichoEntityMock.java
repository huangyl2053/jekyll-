/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.helper;

import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.HihokenshashoSaikofuJiyu;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.HihokenshashoSaikofuKubun;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.JushochitokureiKaijoJiyu;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.JushochitokureiTekiyoJiyu;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.KoikinaiJushochitokureishaKubun;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.ShikakuHenkoJiyu;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.ShikakuShutokuJiyu;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.ShikakuSoshitsuJiyu;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.JushochiTokureishaKubun;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.mockito.Mockito.*;

/**
 * DbT1001HihokenshaDaichoEntityのMockクラスです。
 *
 * @author N3327 三浦 凌
 */
public final class DbT1001HihokenshaDaichoEntityMock {

    /**
     * {@link DbT1001HihokenshaDaichoEntity DbT1001HihokenshaDaichoEntity}の
     * {@link org.mockito.Mockito#spy(java.lang.Object)  スパイインスタンス}を返します。
     *
     * @return DbT1001HihokenshaDaichoEntityのスパイ
     */
    public static DbT1001HihokenshaDaichoEntity getSpiedInstance() {
        DbT1001HihokenshaDaichoEntity entity = create();
        return spy(entity);
    }

    /**
     * テスト用にDbT1001HihokenshaDaichoEntityを生成します。
     *
     * @return DbT1001HihokenshaDaichoEntity
     */
    public static DbT1001HihokenshaDaichoEntity create() {
        DbT1001HihokenshaDaichoEntity entity = new DbT1001HihokenshaDaichoEntity();
        entity.setShichosonCode(new LasdecCode(new RString("000000")));
        entity.setShoKisaiHokenshaNo(new ShoKisaiHokenshaNo(new RString("000000")));
        entity.setHihokenshaNo(new KaigoHihokenshaNo(new RString("1234567890")));
        entity.setShikibetsuCode(new ShikibetsuCode("0000000001"));
        entity.setShoriTimestamp(new YMDHMS("20140328000000"));
        entity.setHihokennshaKubunCode(new Code("1"));
        entity.setIchigoHihokenshaNenreiTotatsuYMD(new FlexibleDate("20140328"));
        entity.setShikakuShutokuJiyuCode(ShikakuShutokuJiyu.年齢到達.getCode());
        entity.setShikakuShutokuTodokedeYMD(new FlexibleDate("20130327"));
        entity.setShikakuShutokuYMD(new FlexibleDate("20130327"));
        entity.setShikakuSoshitsuJiyuCode(ShikakuSoshitsuJiyu.なし.getCode());
        entity.setShikakuSoshitsuTodokedeYMD(new FlexibleDate("00000000"));
        entity.setShikakuSoshitsuYMD(new FlexibleDate("00000000"));
        entity.setShikakuHenkoJiyuCode(ShikakuHenkoJiyu.なし.getCode());
        entity.setShikakuHenkoTodokedeYMD(new FlexibleDate("00000000"));
        entity.setShikakuHenkoYMD(new FlexibleDate("00000000"));
        entity.setJushochitokureiTekiyoJiyuCode(JushochitokureiTekiyoJiyu.なし.getCode());
        entity.setJushochitokureiTekiyoTodokedeYMD(new FlexibleDate("00000000"));
        entity.setJushochitokureiTekiyoYMD(new FlexibleDate("00000000"));
        entity.setJushochitokureiKaijoJiyuCode(JushochitokureiKaijoJiyu.なし.getCode());
        entity.setJushochitokureiKaijoTodokedeYMD(new FlexibleDate("00000000"));
        entity.setJushochitokureiKaijoYMD(new FlexibleDate("00000000"));
        entity.setJushochiTokureiFlag(JushochiTokureishaKubun.通常資格者.getコード());
        entity.setKoikinaiJushochiTokureiFlag(KoikinaiJushochitokureishaKubun.通常資格者.getCode());
        entity.setKoikinaiTokureiSochimotoHokenshaNo(null);
        entity.setKyuShichosonCode(null);
        entity.setSaikofuKubun(HihokenshashoSaikofuKubun.なし.getCode());
        entity.setSaikofuJiyuCode(HihokenshashoSaikofuJiyu.なし.getCode());
        entity.setChohyoKofuRirekiID(null);

        return entity;
    }

    /**
     * 市町村コード、識別コード、処理日時を指定して、DbT1001HihokenshaDaichoEntityを生成します。
     *
     * @param shichosonCode 市町村コード
     * @param shikibetsuCode 識別コード
     * @param timeStamp 処理日時
     * @return DbT1001HihokenshaDaichoEntity
     */
    public static DbT1001HihokenshaDaichoEntity createWithKey(
            LasdecCode shichosonCode, ShikibetsuCode shikibetsuCode, YMDHMS timeStamp) {
        DbT1001HihokenshaDaichoEntity entity = create();
        entity.setShichosonCode(shichosonCode);
        entity.setShikibetsuCode(shikibetsuCode);
        entity.setShoriTimestamp(timeStamp);
        return entity;
    }

    /**
     * 市町村コード、被保険者番号、処理日時を指定して、DbT1001HihokenshaDaichoEntityを生成します。
     *
     * @param shichosonCode 市町村コード
     * @param hihokenshaNo 被保険者番号
     * @param timeStamp 処理日時
     * @return DbT1001HihokenshaDaichoEntity
     */
    public static DbT1001HihokenshaDaichoEntity createWithKey(
            LasdecCode shichosonCode, KaigoHihokenshaNo hihokenshaNo, YMDHMS timeStamp) {
        DbT1001HihokenshaDaichoEntity entity = create();
        entity.setShichosonCode(shichosonCode);
        entity.setHihokenshaNo(hihokenshaNo);
        entity.setShoriTimestamp(timeStamp);
        return entity;
    }
}
