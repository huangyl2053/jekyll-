/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.mapper;

import jp.co.ndensan.reams.db.dbe.business.NinteiResult;
import jp.co.ndensan.reams.db.dbe.business.NinteiRiyu;
import jp.co.ndensan.reams.db.dbe.business.NinteiShinsakaiIken;
import jp.co.ndensan.reams.db.dbe.business.NinteiYukoKikan;
import jp.co.ndensan.reams.db.dbe.business.TokuteiShippeiKubun;
import jp.co.ndensan.reams.db.dbe.business.YokaigoJotaiKubun;
import jp.co.ndensan.reams.db.dbe.business.YokaigoJotaizoRei;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.KaigoServiceShurui;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.NinteiKekkaIdoJiyu;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShinsakaiIkenShurui;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.NinteiYukoKikanTsukisu;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinsakaiKaisaiNo;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5002NinteiKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定結果情報を変換するMapperクラスです。
 *
 * @author N8156 宮本 康
 */
public final class NinteiKekkaMapper {

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private NinteiKekkaMapper() {
    }

    /**
     * 引数の認定結果情報エンティティから認定結果情報を作成して返します。
     *
     * @param entity 認定結果エンティティ
     * @return 認定結果情報
     */
    public static NinteiResult toNinteiResult(DbT5002NinteiKekkaJohoEntity entity) {
        NinteiYukoKikan 認定有効期間 = new NinteiYukoKikan(
                new NinteiYukoKikanTsukisu(entity.getNinteiYukoKikan()),
                entity.getNinteiYukoKaishiYMD(),
                entity.getNinteiYukoShuryoYMD());
        NinteiShinsakaiIken 認定審査会意見 = new NinteiShinsakaiIken(
                new ShinsakaiKaisaiNo(entity.getShinsakaiKaisaiNo()),
                ShinsakaiIkenShurui.toValue(entity.getNinteishinsakaiIkenShurui()),
                entity.getShinsakaiIken(),
                entity.getShinsakaiMemo());
        NinteiRiyu 認定理由 = new NinteiRiyu(
                entity.getIchijiHnateiKekkaHenkoRiyu(),
                NinteiKekkaIdoJiyu.toValue(entity.getNinteiKekkaIdoJiyu()),
                entity.getNinteiKekkaIdoYMD(),
                entity.getNinteiTorikeshiRiyu(),
                entity.getNinteiTorikeshiYMD(),
                entity.getNinteiRiyu());
        return new NinteiResult(
                new ShinseishoKanriNo(entity.getShinseishoKanriNo()),
                entity.getYoukaigodoNinteiYMD(),
                new YokaigoJotaiKubun(entity.getYoukaigoJotaiKubunCode(), RString.EMPTY, RString.EMPTY),
                new YokaigoJotaizoRei(entity.getYokaigoJotaizoReiCode(), RString.EMPTY, RString.EMPTY),
                認定有効期間,
                KaigoServiceShurui.toValue(entity.getKaigoServiceShurui()),
                entity.getShisetsuNyushoFlag(),
                new TokuteiShippeiKubun(entity.getTokuteiShippeiCode(), RString.EMPTY, RString.EMPTY),
                認定審査会意見,
                認定理由);
    }

    /**
     * 引数の認定結果情報から認定結果情報エンティティを作成して返します。
     *
     * @param ninteiResult 認定結果
     * @return 認定結果情報エンティティ
     */
    public static DbT5002NinteiKekkaJohoEntity toDbT5002NinteiKekkaJohoEntity(NinteiResult ninteiResult) {
        DbT5002NinteiKekkaJohoEntity entity = new DbT5002NinteiKekkaJohoEntity();
        entity.setShinseishoKanriNo(ninteiResult.get申請書管理番号().value());
        entity.setYoukaigodoNinteiYMD(ninteiResult.get要介護度認定年月日());
        entity.setYoukaigoJotaiKubunCode(ninteiResult.get要介護状態区分().getCode());
        entity.setNinteiYukoKikan(ninteiResult.get認定有効期間().get有効期間月数().value().intValue());
        entity.setNinteiYukoKaishiYMD(ninteiResult.get認定有効期間().get有効期間().getFrom());
        entity.setNinteiYukoShuryoYMD(ninteiResult.get認定有効期間().get有効期間().getTo());
        entity.setTokuteiShippeiCode(ninteiResult.get特定疾病区分().getCode());
        entity.setShisetsuNyushoFlag(ninteiResult.is施設入所有無());
        entity.setShinsakaiKaisaiNo(ninteiResult.get認定審査会意見().get審査会開催番号().value().intValue());
        entity.setShinsakaiIken(ninteiResult.get認定審査会意見().get審査会意見());
        entity.setIchijiHnateiKekkaHenkoRiyu(ninteiResult.get認定理由().get一次判定結果変更理由());
        entity.setYokaigoJotaizoReiCode(ninteiResult.get要介護状態像例().getCode());
        entity.setNinteishinsakaiIkenShurui(ninteiResult.get認定審査会意見().get審査会意見種類().getCode());
        entity.setKaigoServiceShurui(ninteiResult.get介護サービス種類().getCode());
        entity.setNinteiKekkaIdoJiyu(ninteiResult.get認定理由().get認定結果異動事由().getCode());
        entity.setNinteiKekkaIdoYMD(ninteiResult.get認定理由().get認定結果異動年月日());
        entity.setNinteiTorikeshiRiyu(ninteiResult.get認定理由().get認定取消理由());
        entity.setNinteiTorikeshiYMD(ninteiResult.get認定理由().get認定取消年月日());
        entity.setNinteiRiyu(ninteiResult.get認定理由().get認定理由());
        entity.setShinsakaiMemo(ninteiResult.get認定審査会意見().get審査会メモ());
        return entity;
    }
}
