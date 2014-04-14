/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.mapper;

import jp.co.ndensan.reams.db.dbe.business.NinteiResult;
import jp.co.ndensan.reams.db.dbe.business.NinteiResultIdo;
import jp.co.ndensan.reams.db.dbe.business.NinteiShinsakaiIken;
import jp.co.ndensan.reams.db.dbe.business.NinteiTorikeshi;
import jp.co.ndensan.reams.db.dbe.business.NinteiYukoKikan;
import jp.co.ndensan.reams.db.dbe.business.TokuteiShippei;
import jp.co.ndensan.reams.db.dbe.business.YokaigoJotai;
import jp.co.ndensan.reams.db.dbe.business.YokaigoJotaiKubun;
import jp.co.ndensan.reams.db.dbe.business.YokaigoJotaizoRei;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.KaigoServiceType;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.NinteiResultIdoJiyuKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShinsakaiIkenType;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShisetsuNyushoKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.TsuchiKubun;
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
        if (entity == null) {
            return null;
        }
        return new NinteiResult(
                new ShinseishoKanriNo(entity.getShinseishoKanriNo()),
                entity.getYoukaigodoNinteiYMD(),
                create要介護状態(entity),
                new YokaigoJotaizoRei(entity.getYokaigoJotaizoReiCode(), RString.EMPTY, RString.EMPTY),
                KaigoServiceType.toValue(entity.getKaigoServiceShurui()),
                ShisetsuNyushoKubun.toValue(entity.getShisetsuNyushoFlag()),
                new TokuteiShippei(entity.getTokuteiShippeiCode(), RString.EMPTY, RString.EMPTY),
                create認定審査会意見(entity),
                new NinteiResultIdo(NinteiResultIdoJiyuKubun.toValue(entity.getNinteiKekkaIdoJiyu()), entity.getNinteiKekkaIdoYMD()),
                new NinteiTorikeshi(entity.getNinteiTorikeshiRiyu(), entity.getNinteiTorikeshiYMD()),
                TsuchiKubun.toValue(entity.getTuchiKubun()),
                entity.getNinteiRiyu());
    }

    private static YokaigoJotai create要介護状態(DbT5002NinteiKekkaJohoEntity entity) {
        return new YokaigoJotai(
                new YokaigoJotaiKubun(entity.getYoukaigoJotaiKubunCode(), RString.EMPTY, RString.EMPTY),
                create認定有効期間(entity));
    }

    private static NinteiYukoKikan create認定有効期間(DbT5002NinteiKekkaJohoEntity entity) {
        return new NinteiYukoKikan(
                entity.getNinteiYukoKaishiYMD(),
                new NinteiYukoKikanTsukisu(entity.getNinteiYukoKikan()),
                entity.getNinteiYukoShuryoYMD());
    }

    private static NinteiShinsakaiIken create認定審査会意見(DbT5002NinteiKekkaJohoEntity entity) {
        return new NinteiShinsakaiIken(
                new ShinsakaiKaisaiNo(entity.getShinsakaiKaisaiNo()),
                ShinsakaiIkenType.toValue(entity.getNinteishinsakaiIkenShurui()),
                entity.getShinsakaiIken(),
                entity.getShinsakaiMemo(),
                entity.getIchijiHnateiKekkaHenkoRiyu());
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
        entity.setYoukaigoJotaiKubunCode(ninteiResult.get要介護状態().get要介護状態区分().getCode());
        entity.setNinteiYukoKikan(ninteiResult.get要介護状態().get認定有効期間().get有効期間月数().value().intValue());
        entity.setNinteiYukoKaishiYMD(ninteiResult.get要介護状態().get認定有効期間().get有効期間().getFrom());
        entity.setNinteiYukoShuryoYMD(ninteiResult.get要介護状態().get認定有効期間().get有効期間().getTo());
        entity.setTokuteiShippeiCode(ninteiResult.get特定疾病().getCode());
        entity.setShisetsuNyushoFlag(ninteiResult.get施設入所区分().is施設入所());
        entity.setShinsakaiKaisaiNo(ninteiResult.get認定審査会意見().get審査会開催番号().value().intValue());
        entity.setShinsakaiIken(ninteiResult.get認定審査会意見().get審査会意見());
        entity.setIchijiHnateiKekkaHenkoRiyu(ninteiResult.get認定審査会意見().get一次判定結果変更理由());
        entity.setYokaigoJotaizoReiCode(ninteiResult.get要介護状態像例().getCode());
        entity.setNinteishinsakaiIkenShurui(ninteiResult.get認定審査会意見().get審査会意見種類().getCode());
        entity.setKaigoServiceShurui(ninteiResult.get介護サービス種類().getCode());
        entity.setNinteiKekkaIdoJiyu(ninteiResult.get認定結果異動().get認定結果異動事由区分().getCode());
        entity.setNinteiKekkaIdoYMD(ninteiResult.get認定結果異動().get認定結果異動年月日());
        entity.setNinteiTorikeshiRiyu(ninteiResult.get認定取消().get認定取消理由());
        entity.setNinteiTorikeshiYMD(ninteiResult.get認定取消().get認定取消年月日());
        entity.setTuchiKubun(ninteiResult.get通知区分().getCode());
        entity.setNinteiRiyu(ninteiResult.get認定理由());
        entity.setShinsakaiMemo(ninteiResult.get認定審査会意見().get審査会メモ());
        return entity;
    }
}
