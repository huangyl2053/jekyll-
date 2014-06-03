/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.helper;

import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.NinteiResultIdoJiyuKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShinsakaiIkenType;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.TsuchiKubun;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5002NinteiKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.mockito.Mockito.spy;

/**
 * DbT5002NinteiKekkaJohoEntityを生成するMockです。
 *
 * @author N8156 宮本 康
 */
public class DbT5002NinteiKekkaJohoEntityMock {

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT5002NinteiKekkaJohoEntityMock() {
    }

    /**
     * DbT5002NinteiKekkaJohoEntityを生成して返します。
     *
     * @return DbT5002NinteiKekkaJohoEntity
     */
    public static DbT5002NinteiKekkaJohoEntity getSpiedInstance() {
        return spy(getDbT5002NinteiKekkaJohoEntity());
    }

    /**
     * DbT5002NinteiKekkaJohoEntityを生成して返します。
     *
     * @return DbT5002NinteiKekkaJohoEntity
     */
    public static DbT5002NinteiKekkaJohoEntity getDbT5002NinteiKekkaJohoEntity() {
        DbT5002NinteiKekkaJohoEntity entity = new DbT5002NinteiKekkaJohoEntity();
        entity.setShinseishoKanriNo(new ShinseishoKanriNo(new RString("1234567890")));
        entity.setShoKisaiHokenshaNo(new ShoKisaiHokenshaNo(new RString("123456")));
        entity.setHihokenshaNo(new KaigoHihokenshaNo(new RString("1234567890")));
        entity.setYoukaigodoNinteiYMD(new FlexibleDate("20140101"));
        entity.setYoukaigoJotaiKubunCode(new Code("111111"));
        entity.setNinteiYukoKikan(1);
        entity.setNinteiYukoKaishiYMD(new FlexibleDate("20140202"));
        entity.setNinteiYukoShuryoYMD(new FlexibleDate("20140303"));
        entity.setTokuteiShippeiCode(new Code("333333"));
        entity.setShisetsuNyushoFlag(true);
        entity.setShinsakaiKaisaiNo(123);
        entity.setShinsakaiIken(new RString("審査会意見"));
        entity.setIchijiHnateiKekkaHenkoRiyu(new RString("一次判定結果変更理由"));
        entity.setYokaigoJotaizoReiCode(new Code("222222"));
        entity.setNinteishinsakaiIkenShurui(ShinsakaiIkenType.サービス利用への意見.getCode());
        entity.setKaigoServiceShurui01(new RString("01"));
        entity.setNinteiKekkaIdoJiyu(NinteiResultIdoJiyuKubun.職権追加.getCode());
        entity.setNinteiKekkaIdoYMD(new FlexibleDate("20140404"));
        entity.setNinteiTorikeshiRiyu(new RString("認定取消理由"));
        entity.setNinteiTorikeshiYMD(new FlexibleDate("20140505"));
        entity.setTuchiKubun(TsuchiKubun.認定.getCode());
        entity.setNinteiRiyu(new RString("認定理由"));
        entity.setShinsakaiMemo(new RString("審査会メモ"));
        return entity;
    }
}
