/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceCode;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3095JutakuKaishuRiyushoTesuryoMeisaiEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 住宅改修理由書作成手数料請求明細エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author LDNS 宋昕沢
 */
public final class DbT3095JutakuKaishuRiyushoTesuryoMeisaiEntityGenerator {

    public static final HokenshaNo DEFAULT_証記載保険者番号 = new HokenshaNo(new RString("025498"));
    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo(new RString("02"));
    public static final YMDHMS DEFAULT_処理日時 = new YMDHMS(new RString("20140415102030"));
    public static final ShikibetsuCode DEFAULT_識別コード = new ShikibetsuCode("000001234567890");
    public static final ServiceCode DEFAULT_サービスコード = new ServiceCode(new RString("0212"));
    public static final AtenaMeisho DEFAULT_介護住宅改修事業者名称 = new AtenaMeisho("電算太郎");
    public static final FlexibleDate DEFAULT_介護住宅改修着工年月日 = new FlexibleDate("20140402");
    public static final AtenaMeisho DEFAULT_介護住宅改修住宅所有者 = new AtenaMeisho("電算太郎");
    public static final RString DEFAULT_改修対象住宅住所 = new RString("123");
    public static final RString DEFAULT_改修内容_箇所及び規模 = new RString("123");
    public static final FlexibleDate DEFAULT_介護住宅改修理由書作成年月日 = new FlexibleDate("20140402");
    public static final JigyoshaNo DEFAULT_介護住宅改修理由書作成事業者番号 = new JigyoshaNo(new RString("0211"));
    public static final AtenaMeisho DEFAULT_介護住宅改修理由書作成者名 = new AtenaMeisho("電算太郎");
    public static final RString DEFAULT_介護住宅改修理由書作成者資格 = new RString("1");
    public static final FlexibleDate DEFAULT_介護住宅改修理由書作成申請年月日 = new FlexibleDate("20140402");
    public static final FlexibleDate DEFAULT_介護住宅改修理由書作成受付年月日 = new FlexibleDate("20140402");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3095JutakuKaishuRiyushoTesuryoMeisaiEntityGenerator() {
    }

    public static DbT3095JutakuKaishuRiyushoTesuryoMeisaiEntity createDbT3095JutakuKaishuRiyushoTesuryoMeisaiEntity() {
        DbT3095JutakuKaishuRiyushoTesuryoMeisaiEntity entity = new DbT3095JutakuKaishuRiyushoTesuryoMeisaiEntity();
        entity.setShoKisaiHokenshaNo(DEFAULT_証記載保険者番号);
        entity.setHihokenshaNo(DEFAULT_被保険者番号);
        entity.setShoriTimestamp(DEFAULT_処理日時);
        entity.setShikibetsuCode(DEFAULT_識別コード);
        entity.setServiceCode(DEFAULT_サービスコード);
        entity.setJutakuKaishuJigyoshaMeisho(DEFAULT_介護住宅改修事業者名称);
        entity.setJutakuKaishuChakkoYMD(DEFAULT_介護住宅改修着工年月日);
        entity.setJutakuKaishuJushoShozaisha(DEFAULT_介護住宅改修住宅所有者);
        entity.setKaishuTaishoJutakuJusho(DEFAULT_改修対象住宅住所);
        entity.setKaishuNaiyo_kasho_Kibo(DEFAULT_改修内容_箇所及び規模);
        entity.setRiyushoSakuseiYMD(DEFAULT_介護住宅改修理由書作成年月日);
        entity.setRiyushoSakuseiJigyoshaNo(DEFAULT_介護住宅改修理由書作成事業者番号);
        entity.setRiyushoSakuseishaMei(DEFAULT_介護住宅改修理由書作成者名);
        entity.setRiyushoSakuseishaShikaku(DEFAULT_介護住宅改修理由書作成者資格);
        entity.setRiyushoSakuseiShinseiYMD(DEFAULT_介護住宅改修理由書作成申請年月日);
        entity.setRiyushoSakuseiUketsukeYMD(DEFAULT_介護住宅改修理由書作成受付年月日);
        return entity;
    }
}
