/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7004KaigoShiharaiJohoEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.NinshoshaCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHM;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護支払情報エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author LDNS 宋昕沢
 */
public final class DbT7004KaigoShiharaiJohoEntityGenerator {

    public static final ShoKisaiHokenshaNo DEFAULT_証記載保険者番号 = new ShoKisaiHokenshaNo(new RString("02"));
    public static final ShikibetsuCode DEFAULT_識別コード = new ShikibetsuCode("000001234567890");
    public static final KamokuCode DEFAULT_科目コード = new KamokuCode(new RString("010"));
    public static final FlexibleDate DEFAULT_決定年月日 = new FlexibleDate("20140402");
    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo(new RString("02"));
    public static final RString DEFAULT_支払方法区分 = new RString("3");
    public static final Code DEFAULT_窓口支払場所コード = new Code("3");
    public static final YMDHM DEFAULT_窓口支払開始年月日時分 = new YMDHM(new RString("201404151020"));
    public static final YMDHM DEFAULT_窓口支払終了年月日時分 = new YMDHM(new RString("201404151020"));
    public static final FlexibleDate DEFAULT_振込予定年月日 = new FlexibleDate("20140402");
    public static final int DEFAULT_支払金額 = 1;
    public static final Code DEFAULT_種別コード = new Code("3");
    public static final Code DEFAULT_用途区分コード = new Code("3");
    public static final FlexibleDate DEFAULT_認証日１ = new FlexibleDate("20140402");
    public static final NinshoshaCode DEFAULT_認証者コード１ = new NinshoshaCode(new RString("0112"));
    public static final FlexibleDate DEFAULT_認証日２ = new FlexibleDate("20140402");
    public static final NinshoshaCode DEFAULT_認証者コード２ = new NinshoshaCode(new RString("0112"));

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT7004KaigoShiharaiJohoEntityGenerator() {
    }

    public static DbT7004KaigoShiharaiJohoEntity createDbT7004KaigoShiharaiJohoEntity() {
        DbT7004KaigoShiharaiJohoEntity entity = new DbT7004KaigoShiharaiJohoEntity();
        entity.setShoKisaiHokenshaNo(DEFAULT_証記載保険者番号);
        entity.setShikibetsuCode(DEFAULT_識別コード);
        entity.setKamokuCode(DEFAULT_科目コード);
        entity.setKetteiYMD(DEFAULT_決定年月日);
        entity.setHihokenshaNo(DEFAULT_被保険者番号);
        entity.setShiharaiHohoKubun(DEFAULT_支払方法区分);
        entity.setMadoguchiShiharaiBashoCode(DEFAULT_窓口支払場所コード);
        entity.setMadoguchiShiharaiKaishiYMDHM(DEFAULT_窓口支払開始年月日時分);
        entity.setMadoguchiShiharaiShuryoYMDHM(DEFAULT_窓口支払終了年月日時分);
        entity.setFurikomiYoteiYMD(DEFAULT_振込予定年月日);
        entity.setShiharaiKingaku(DEFAULT_支払金額);
        entity.setShubetsuCode(DEFAULT_種別コード);
        entity.setYotoKubunCode(DEFAULT_用途区分コード);
        entity.setNinshoYMD1(DEFAULT_認証日１);
        entity.setNinshoshaCode1(DEFAULT_認証者コード１);
        entity.setNinshoYMD2(DEFAULT_認証日２);
        entity.setNinshoshaCode2(DEFAULT_認証者コード２);
        return entity;
    }
}
