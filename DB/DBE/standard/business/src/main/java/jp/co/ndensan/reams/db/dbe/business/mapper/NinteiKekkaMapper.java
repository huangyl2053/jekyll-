/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.mapper;

import jp.co.ndensan.reams.db.dbe.business.NinteiResult;
import jp.co.ndensan.reams.db.dbe.business.NinteiResultIdo;
import jp.co.ndensan.reams.db.dbe.business.NinteiShinsakaiIken;
import jp.co.ndensan.reams.db.dbe.business.NinteiTorikeshi;
import jp.co.ndensan.reams.db.dbe.business.NinteiYukoKikan;
import jp.co.ndensan.reams.db.dbe.business.TokuteiShippei;
import jp.co.ndensan.reams.db.dbe.business.YokaigoJotai;
import jp.co.ndensan.reams.db.dbe.business.YokaigoJotaiKubun;
import jp.co.ndensan.reams.db.dbe.business.YokaigoJotaizoRei;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.NinteiResultIdoJiyuKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShinsakaiIkenType;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShisetsuNyushoKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.TsuchiKubun;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.NinteiYukoKikanTsukisu;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinsakaiKaisaiNo;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5002NinteiKekkaJohoEntity;
import jp.co.ndensan.reams.ur.urz.business.IKaigoServiceShurui;
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
     * @param 介護サービス種類０１ 介護サービス種類０１
     * @param 介護サービス種類０２ 介護サービス種類０２
     * @param 介護サービス種類０３ 介護サービス種類０３
     * @param 介護サービス種類０４ 介護サービス種類０４
     * @param 介護サービス種類０５ 介護サービス種類０５
     * @param 介護サービス種類０６ 介護サービス種類０６
     * @param 介護サービス種類０７ 介護サービス種類０７
     * @param 介護サービス種類０８ 介護サービス種類０８
     * @param 介護サービス種類０９ 介護サービス種類０９
     * @param 介護サービス種類１０ 介護サービス種類１０
     * @param 介護サービス種類１１ 介護サービス種類１１
     * @param 介護サービス種類１２ 介護サービス種類１２
     * @param 介護サービス種類１３ 介護サービス種類１３
     * @param 介護サービス種類１４ 介護サービス種類１４
     * @param 介護サービス種類１５ 介護サービス種類１５
     * @param 介護サービス種類１６ 介護サービス種類１６
     * @param 介護サービス種類１７ 介護サービス種類１７
     * @param 介護サービス種類１８ 介護サービス種類１８
     * @param 介護サービス種類１９ 介護サービス種類１９
     * @param 介護サービス種類２０ 介護サービス種類２０
     * @param 介護サービス種類２１ 介護サービス種類２１
     * @param 介護サービス種類２２ 介護サービス種類２２
     * @param 介護サービス種類２３ 介護サービス種類２３
     * @param 介護サービス種類２４ 介護サービス種類２４
     * @param 介護サービス種類２５ 介護サービス種類２５
     * @param 介護サービス種類２６ 介護サービス種類２６
     * @param 介護サービス種類２７ 介護サービス種類２７
     * @param 介護サービス種類２８ 介護サービス種類２８
     * @param 介護サービス種類２９ 介護サービス種類２９
     * @param 介護サービス種類３０ 介護サービス種類３０
     * @return 認定結果情報
     */
    public static NinteiResult toNinteiResult(DbT5002NinteiKekkaJohoEntity entity, IKaigoServiceShurui 介護サービス種類０１,
            IKaigoServiceShurui 介護サービス種類０２, IKaigoServiceShurui 介護サービス種類０３, IKaigoServiceShurui 介護サービス種類０４,
            IKaigoServiceShurui 介護サービス種類０５, IKaigoServiceShurui 介護サービス種類０６, IKaigoServiceShurui 介護サービス種類０７,
            IKaigoServiceShurui 介護サービス種類０８, IKaigoServiceShurui 介護サービス種類０９, IKaigoServiceShurui 介護サービス種類１０,
            IKaigoServiceShurui 介護サービス種類１１, IKaigoServiceShurui 介護サービス種類１２, IKaigoServiceShurui 介護サービス種類１３,
            IKaigoServiceShurui 介護サービス種類１４, IKaigoServiceShurui 介護サービス種類１５, IKaigoServiceShurui 介護サービス種類１６,
            IKaigoServiceShurui 介護サービス種類１７, IKaigoServiceShurui 介護サービス種類１８, IKaigoServiceShurui 介護サービス種類１９,
            IKaigoServiceShurui 介護サービス種類２０, IKaigoServiceShurui 介護サービス種類２１, IKaigoServiceShurui 介護サービス種類２２,
            IKaigoServiceShurui 介護サービス種類２３, IKaigoServiceShurui 介護サービス種類２４, IKaigoServiceShurui 介護サービス種類２５,
            IKaigoServiceShurui 介護サービス種類２６, IKaigoServiceShurui 介護サービス種類２７, IKaigoServiceShurui 介護サービス種類２８,
            IKaigoServiceShurui 介護サービス種類２９, IKaigoServiceShurui 介護サービス種類３０) {
        if (entity == null) {
            return null;
        }
        return new NinteiResult(
                entity.getShinseishoKanriNo(),
                entity.getShoriTimestamp(),
                entity.getShoKisaiHokenshaNo(),
                entity.getHihokenshaNo(),
                entity.getYoukaigodoNinteiYMD(),
                create要介護状態(entity),
                new YokaigoJotaizoRei(entity.getYokaigoJotaizoReiCode(), RString.EMPTY, RString.EMPTY),
                介護サービス種類０１,
                介護サービス種類０２,
                介護サービス種類０３,
                介護サービス種類０４,
                介護サービス種類０５,
                介護サービス種類０６,
                介護サービス種類０７,
                介護サービス種類０８,
                介護サービス種類０９,
                介護サービス種類１０,
                介護サービス種類１１,
                介護サービス種類１２,
                介護サービス種類１３,
                介護サービス種類１４,
                介護サービス種類１５,
                介護サービス種類１６,
                介護サービス種類１７,
                介護サービス種類１８,
                介護サービス種類１９,
                介護サービス種類２０,
                介護サービス種類２１,
                介護サービス種類２２,
                介護サービス種類２３,
                介護サービス種類２４,
                介護サービス種類２５,
                介護サービス種類２６,
                介護サービス種類２７,
                介護サービス種類２８,
                介護サービス種類２９,
                介護サービス種類３０,
                ShisetsuNyushoKubun.toValue(entity.getShisetsuNyushoFlag()),
                new TokuteiShippei(entity.getTokuteiShippeiCode(), RString.EMPTY, RString.EMPTY),
                create認定審査会意見(entity),
                new NinteiResultIdo(NinteiResultIdoJiyuKubun.toValue(entity.getNinteiKekkaIdoJiyu()), entity.getNinteiKekkaIdoYMD()),
                new NinteiTorikeshi(entity.getNinteiTorikeshiRiyu(), entity.getNinteiTorikeshiYMD()),
                TsuchiKubun.toValue(entity.getTuchiKubun()),
                entity.getNinteiRiyu(),
                entity.getIfSofuYMD());
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
        entity.setShinseishoKanriNo(ninteiResult.get申請書管理番号());
        entity.setShoriTimestamp(ninteiResult.get処理日時());
        entity.setShoKisaiHokenshaNo(ninteiResult.get証記載保険者番号());
        entity.setHihokenshaNo(ninteiResult.get被保険者番号());
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
        entity.setKaigoServiceShurui01(ninteiResult.get介護サービス種類０１().getサービス種類コード());
        entity.setNinteiKekkaIdoJiyu(ninteiResult.get認定結果異動().get認定結果異動事由区分().getCode());
        entity.setNinteiKekkaIdoYMD(ninteiResult.get認定結果異動().get認定結果異動年月日());
        entity.setNinteiTorikeshiRiyu(ninteiResult.get認定取消().get認定取消理由());
        entity.setNinteiTorikeshiYMD(ninteiResult.get認定取消().get認定取消年月日());
        entity.setTuchiKubun(ninteiResult.get通知区分().getCode());
        entity.setNinteiRiyu(ninteiResult.get認定理由());
        entity.setShinsakaiMemo(ninteiResult.get認定審査会意見().get審査会メモ());
        entity.setIfSofuYMD(ninteiResult.getIF送付年月日());
        return entity;
    }
}
