/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1002TekiyoJogaishaEntity;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.KaigoJogaiTekiyoJiyu;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.KaigoJogaiKaijoJiyu;
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
 * 適用除外者エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author n8178 城間篤人
 */
public final class DbT1002TekiyoJogaishaEntityGenerator {

    public static final LasdecCode DEFAULT_市町村コード = new LasdecCode("000010");
    public static final ShikibetsuCode DEFAULT_識別コード = new ShikibetsuCode("000010000100001");
    public static final YMDHMS DEFAULT_処理日時 = new YMDHMS("20160712123456");
    public static final KaigoJogaiTekiyoJiyu DEFAULT_適用除外適用事由コード = new KaigoJogaiTekiyoJiyu(new Code("31"));
    public static final FlexibleDate DEFAULT_適用年月日 = new FlexibleDate("20160712");
    public static final FlexibleDate DEFAULT_適用届出年月日 = new FlexibleDate("20160712");
    public static final FlexibleDate DEFAULT_適用受付年月日 = new FlexibleDate("20160712");
    public static final KaigoJogaiKaijoJiyu DEFAULT_適用除外解除事由コード = new KaigoJogaiKaijoJiyu(new Code("81"));
    public static final FlexibleDate DEFAULT_解除年月日 = new FlexibleDate("20170130");
    public static final FlexibleDate DEFAULT_解除届出年月日 = new FlexibleDate("20170130");
    public static final FlexibleDate DEFAULT_解除受付年月日 = new FlexibleDate("20170130");
    public static final FlexibleDate DEFAULT_入所通知発行日 = new FlexibleDate("20160713");
    public static final FlexibleDate DEFAULT_退所通知発行日 = new FlexibleDate("20170202");
    public static final FlexibleDate DEFAULT_変更通知発行日 = new FlexibleDate("20161201");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT1002TekiyoJogaishaEntityGenerator() {
    }

    public static DbT1002TekiyoJogaishaEntity createDbT1002TekiyoJogaishaEntity() {
        DbT1002TekiyoJogaishaEntity entity = new DbT1002TekiyoJogaishaEntity();
        entity.setShichosonCode(DEFAULT_市町村コード);
        entity.setShikibetsuCode(DEFAULT_識別コード);
        entity.setShoriTimestamp(DEFAULT_処理日時);
        entity.setTekiyoJogaiTekiyoJiyuCode(DEFAULT_適用除外適用事由コード);
        entity.setTekiyoYMD(DEFAULT_適用年月日);
        entity.setTekiyoTodokedeYMD(DEFAULT_適用届出年月日);
        entity.setTekiyoUketsukeYMD(DEFAULT_適用受付年月日);
        entity.setTekiyoJogaikaijokaijoJiyuCode(DEFAULT_適用除外解除事由コード);
        entity.setKaijoYMD(DEFAULT_解除年月日);
        entity.setKaijoTodokedeYMD(DEFAULT_解除届出年月日);
        entity.setKaijoUketsukeYMD(DEFAULT_解除受付年月日);
        entity.setNyushoTsuchiHakkoYMD(DEFAULT_入所通知発行日);
        entity.setTaishoTsuchiHakkoYMD(DEFAULT_退所通知発行日);
        entity.setHenkoTsuchiHakkoYMD(DEFAULT_変更通知発行日);
        return entity;
    }
}
