/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.entity.db.basic.helper;

import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV1002TekiyoJogaishaEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 適用除外者台帳管理Aliveエンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbV1002TekiyoJogaishaEntityGenerator {

    public static final ShikibetsuCode DEFAULT_識別コード = new ShikibetsuCode("012340123400001");
    public static final FlexibleDate DEFAULT_異動日 = new FlexibleDate("19900101");
    public static final RString DEFAULT_枝番 = new RString("Data");
    public static final RString DEFAULT_異動事由コード = new RString("Data");
    public static final LasdecCode DEFAULT_市町村コード = new LasdecCode("209007");
    public static final RString DEFAULT_適用除外適用事由コード = new RString("Data");
    public static final FlexibleDate DEFAULT_適用年月日 = new FlexibleDate("19900101");
    public static final FlexibleDate DEFAULT_適用届出年月日 = new FlexibleDate("19900101");
    public static final FlexibleDate DEFAULT_適用受付年月日 = new FlexibleDate("19900101");
    public static final RString DEFAULT_適用除外解除事由コード = new RString("Data");
    public static final FlexibleDate DEFAULT_解除年月日 = new FlexibleDate("19900101");
    public static final FlexibleDate DEFAULT_解除届出年月日 = new FlexibleDate("19900101");
    public static final FlexibleDate DEFAULT_解除受付年月日 = new FlexibleDate("19900101");
    public static final FlexibleDate DEFAULT_入所通知発行日 = new FlexibleDate("19900101");
    public static final FlexibleDate DEFAULT_退所通知発行日 = new FlexibleDate("19900101");
    public static final FlexibleDate DEFAULT_変更通知発行日 = new FlexibleDate("19900101");
    public static final boolean DEFAULT_論理削除フラグ = false;

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbV1002TekiyoJogaishaEntityGenerator() {
    }

    public static DbV1002TekiyoJogaishaEntity createDbV1002TekiyoJogaishaEntity() {
        DbV1002TekiyoJogaishaEntity entity = new DbV1002TekiyoJogaishaEntity();
        entity.setShikibetsuCode(DEFAULT_識別コード);
        entity.setIdoYMD(DEFAULT_異動日);
        entity.setEdaNo(DEFAULT_枝番);
        entity.setIdoJiyuCode(DEFAULT_異動事由コード);
        entity.setShichosonCode(DEFAULT_市町村コード);
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
        entity.setLogicalDeletedFlag(DEFAULT_論理削除フラグ);
        return entity;
    }
}
