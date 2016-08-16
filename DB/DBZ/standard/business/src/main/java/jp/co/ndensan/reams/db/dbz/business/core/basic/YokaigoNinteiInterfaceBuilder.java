/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4003YokaigoNinteiInterfaceEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link YokaigoNinteiInterface}の編集を行うビルダークラスです。
 *
 * @reamsid_L DBD-9999-013 chenxin
 */
public class YokaigoNinteiInterfaceBuilder {

    private final DbT4003YokaigoNinteiInterfaceEntity entity;
    private final YokaigoNinteiInterfaceIdentifier id;

    /**
     * {@link DbT4003YokaigoNinteiInterfaceEntity}より{@link YokaigoNinteiInterface}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT4003YokaigoNinteiInterfaceEntity}
     * @param id {@link YokaigoNinteiInterfaceIdentifier}
     *
     */
    YokaigoNinteiInterfaceBuilder(
            DbT4003YokaigoNinteiInterfaceEntity entity,
            YokaigoNinteiInterfaceIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

//TODO Key項目のsetterメソッドは削除してください。
//TODO 一緒に置換される値のまとまりで不変なクラスを作成し、その単位でsetterを作る様に見直してください。
    /**
     * Reamsコンフィグから読み取った団体(市町村)コードを設定します。
     *
     * @param Reamsコンフィグから読み取った団体(市町村)コード Reamsコンフィグから読み取った団体(市町村)コード
     * @return {@link YokaigoNinteiInterfaceBuilder}
     */
//    public YokaigoNinteiInterfaceBuilder setReamsコンフィグから読み取った団体(市町村)
//        コード(RString Reamsコンフィグから読み取った団体(市町村)コード) {
//        requireNonNull(Reamsコンフィグから読み取った団体(市町村)コード
//        , UrSystemErrorMessages.値がnull.getReplacedMessage("Reamsコンフィグから読み取った団体(市町村)コード")
//        );
//        entity.setInsertDantaiCd(Reamsコンフィグから読み取った団体(市町村)コード
//        );
//        return this;
//    }
    /**
     * 行挿入日時を設定します。
     *
     * @param 行挿入日時 行挿入日時
     * @return {@link YokaigoNinteiInterfaceBuilder}
     */
//    public YokaigoNinteiInterfaceBuilder set行挿入日時(RDateTime 行挿入日時) {
//        requireNonNull(行挿入日時, UrSystemErrorMessages.値がnull.getReplacedMessage("行挿入日時"));
//        entity.setInsertTimestamp(行挿入日時);
//        return this;
//    }
    /**
     * 行挿入したReamsログインidを設定します。
     *
     * @param 行挿入したReamsログインid 行挿入したReamsログインid
     * @return {@link YokaigoNinteiInterfaceBuilder}
     */
//    public YokaigoNinteiInterfaceBuilder set行挿入したReamsログインid(RString 行挿入したReamsログインid) {
//        requireNonNull(行挿入したReamsログインid, UrSystemErrorMessages.値がnull.getReplacedMessage("行挿入したReamsログインid"));
//        entity.setInsertReamsLoginId(行挿入したReamsログインid);
//        return this;
//    }
    /**
     * 行挿入時の接続コンテキストを設定します。
     *
     * @param 行挿入時の接続コンテキスト 行挿入時の接続コンテキスト
     * @return {@link YokaigoNinteiInterfaceBuilder}
     */
//    public YokaigoNinteiInterfaceBuilder set行挿入時の接続コンテキスト(UUID 行挿入時の接続コンテキスト) {
//        requireNonNull(行挿入時の接続コンテキスト, UrSystemErrorMessages.値がnull.getReplacedMessage("行挿入時の接続コンテキスト"));
//        entity.setInsertContextId(行挿入時の接続コンテキスト);
//        return this;
//    }
    /**
     * 論理削除行を設定します。
     *
     * @param 論理削除行 論理削除行
     * @return {@link YokaigoNinteiInterfaceBuilder}
     */
    public YokaigoNinteiInterfaceBuilder set論理削除行(boolean 論理削除行) {
        requireNonNull(論理削除行, UrSystemErrorMessages.値がnull.getReplacedMessage("論理削除行"));
        entity.setIsDeleted(論理削除行);
        return this;
    }

    /**
     * Update回数を設定します。
     *
     * @param Update回数 Update回数
     * @return {@link YokaigoNinteiInterfaceBuilder}
     */
//    public YokaigoNinteiInterfaceBuilder setUpdate回数(int Update回数) {
//        requireNonNull(Update回数, UrSystemErrorMessages.値がnull.getReplacedMessage("Update回数"));
//        entity.setUpdateCount(Update回数);
//        return this;
//    }
    /**
     * 最終Update日時を設定します。
     *
     * @param 最終Update日時 最終Update日時
     * @return {@link YokaigoNinteiInterfaceBuilder}
     */
//    public YokaigoNinteiInterfaceBuilder set最終Update日時(RDateTime 最終Update日時) {
//        requireNonNull(最終Update日時, UrSystemErrorMessages.値がnull.getReplacedMessage("最終Update日時"));
//        entity.setLastUpdateTimestamp(最終Update日時);
//        return this;
//    }
    /**
     * 最後にupdateしたReamsログインidを設定します。
     *
     * @param 最後にupdateしたReamsログインid 最後にupdateしたReamsログインid
     * @return {@link YokaigoNinteiInterfaceBuilder}
     */
//    public YokaigoNinteiInterfaceBuilder set最後にupdateしたReamsログインid(RString 最後にupdateしたReamsログインid) {
//        requireNonNull(最後にupdateしたReamsログインid, UrSystemErrorMessages.値がnull.getReplacedMessage("最後にupdateしたReamsログインid"));
//        entity.setLastUpdateReamsLoginId(最後にupdateしたReamsログインid);
//        return this;
//    }
    /**
     * 申請書管理番号を設定します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return {@link YokaigoNinteiInterfaceBuilder}
     */
    public YokaigoNinteiInterfaceBuilder set申請書管理番号(ShinseishoKanriNo 申請書管理番号) {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        entity.setShinseishoKanriNo(申請書管理番号);
        return this;
    }

    /**
     * 被保険者番号を設定します。
     *
     * @param 被保険者番号 被保険者番号
     * @return {@link YokaigoNinteiInterfaceBuilder}
     */
    public YokaigoNinteiInterfaceBuilder set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHihokenshaNo(被保険者番号);
        return this;
    }

    /**
     * 履歴番号を設定します。
     *
     * @param 履歴番号 履歴番号
     * @return {@link YokaigoNinteiInterfaceBuilder}
     */
    public YokaigoNinteiInterfaceBuilder set履歴番号(RString 履歴番号) {
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        entity.setRirekiNo(履歴番号);
        return this;
    }

    /**
     * 取込日時を設定します。
     *
     * @param 取込日時 取込日時
     * @return {@link YokaigoNinteiInterfaceBuilder}
     */
    public YokaigoNinteiInterfaceBuilder set取込日時(YMDHMS 取込日時) {
        requireNonNull(取込日時, UrSystemErrorMessages.値がnull.getReplacedMessage("取込日時"));
//        entity.setTorikomiTimestamp(取込日時); TODO
        return this;
    }

    /**
     * 取込区分を設定します。
     *
     * @param 取込区分 取込区分
     * @return {@link YokaigoNinteiInterfaceBuilder}
     */
    public YokaigoNinteiInterfaceBuilder set取込区分(RString 取込区分) {
        requireNonNull(取込区分, UrSystemErrorMessages.値がnull.getReplacedMessage("取込区分"));
//        entity.setTorikomiKubun(取込区分); TODO
        return this;
    }

    /**
     * 申請種別コードを設定します。
     *
     * @param 申請種別コード 申請種別コード
     * @return {@link YokaigoNinteiInterfaceBuilder}
     */
    public YokaigoNinteiInterfaceBuilder set申請種別コード(RString 申請種別コード) {
        requireNonNull(申請種別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("申請種別コード"));
        entity.setShinseiShubetsuCode(申請種別コード);
        return this;
    }

    /**
     * 取下区分コードを設定します。
     *
     * @param 取下区分コード 取下区分コード
     * @return {@link YokaigoNinteiInterfaceBuilder}
     */
    public YokaigoNinteiInterfaceBuilder set取下区分コード(RString 取下区分コード) {
        requireNonNull(取下区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("取下区分コード"));
        entity.setTorisageKubunCode(取下区分コード);
        return this;
    }

    /**
     * 認定申請日を設定します。
     *
     * @param 認定申請日 認定申請日
     * @return {@link YokaigoNinteiInterfaceBuilder}
     */
    public YokaigoNinteiInterfaceBuilder set認定申請日(FlexibleDate 認定申請日) {
        requireNonNull(認定申請日, UrSystemErrorMessages.値がnull.getReplacedMessage("認定申請日"));
        entity.setShinseiYMD(認定申請日);
        return this;
    }

    /**
     * 医療機関コードを設定します。
     *
     * @param 医療機関コード 医療機関コード
     * @return {@link YokaigoNinteiInterfaceBuilder}
     */
    public YokaigoNinteiInterfaceBuilder set医療機関コード(RString 医療機関コード) {
        requireNonNull(医療機関コード, UrSystemErrorMessages.値がnull.getReplacedMessage("医療機関コード"));
        entity.setIryoKikanCode(医療機関コード);
        return this;
    }

    /**
     * 主治医コードを設定します。
     *
     * @param 主治医コード 主治医コード
     * @return {@link YokaigoNinteiInterfaceBuilder}
     */
    public YokaigoNinteiInterfaceBuilder set主治医コード(RString 主治医コード) {
        requireNonNull(主治医コード, UrSystemErrorMessages.値がnull.getReplacedMessage("主治医コード"));
        entity.setShujiiCode(主治医コード);
        return this;
    }

    /**
     * 意見書依頼年月日を設定します。
     *
     * @param 意見書依頼年月日 意見書依頼年月日
     * @return {@link YokaigoNinteiInterfaceBuilder}
     */
    public YokaigoNinteiInterfaceBuilder set意見書依頼年月日(FlexibleDate 意見書依頼年月日) {
        requireNonNull(意見書依頼年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("意見書依頼年月日"));
        entity.setIkenshoIraiYMD(意見書依頼年月日);
        return this;
    }

    /**
     * 意見書取寄せ年月日を設定します。
     *
     * @param 意見書取寄せ年月日 意見書取寄せ年月日
     * @return {@link YokaigoNinteiInterfaceBuilder}
     */
    public YokaigoNinteiInterfaceBuilder set意見書取寄せ年月日(FlexibleDate 意見書取寄せ年月日) {
        requireNonNull(意見書取寄せ年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("意見書取寄せ年月日"));
        entity.setIkenshoToriyoseYMD(意見書取寄せ年月日);
        return this;
    }

    /**
     * 調査委託年月日を設定します。
     *
     * @param 調査委託年月日 調査委託年月日
     * @return {@link YokaigoNinteiInterfaceBuilder}
     */
    public YokaigoNinteiInterfaceBuilder set調査委託年月日(FlexibleDate 調査委託年月日) {
        requireNonNull(調査委託年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("調査委託年月日"));
        entity.setChosaItakuYMD(調査委託年月日);
        return this;
    }

    /**
     * 調査終了年月日を設定します。
     *
     * @param 調査終了年月日 調査終了年月日
     * @return {@link YokaigoNinteiInterfaceBuilder}
     */
    public YokaigoNinteiInterfaceBuilder set調査終了年月日(FlexibleDate 調査終了年月日) {
        requireNonNull(調査終了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("調査終了年月日"));
        entity.setChosaShuryoYMD(調査終了年月日);
        return this;
    }

    /**
     * 調査委託先コードを設定します。
     *
     * @param 調査委託先コード 調査委託先コード
     * @return {@link YokaigoNinteiInterfaceBuilder}
     */
    public YokaigoNinteiInterfaceBuilder set調査委託先コード(JigyoshaNo 調査委託先コード) {
        requireNonNull(調査委託先コード, UrSystemErrorMessages.値がnull.getReplacedMessage("調査委託先コード"));
        entity.setChosaItakusakiCode(調査委託先コード);
        return this;
    }

    /**
     * 調査員コードを設定します。
     *
     * @param 調査員コード 調査員コード
     * @return {@link YokaigoNinteiInterfaceBuilder}
     */
    public YokaigoNinteiInterfaceBuilder set調査員コード(RString 調査員コード) {
        requireNonNull(調査員コード, UrSystemErrorMessages.値がnull.getReplacedMessage("調査員コード"));
        entity.setChosainCode(調査員コード);
        return this;
    }

    /**
     * 一次判定日を設定します。
     *
     * @param 一次判定日 一次判定日
     * @return {@link YokaigoNinteiInterfaceBuilder}
     */
    public YokaigoNinteiInterfaceBuilder set一次判定日(FlexibleDate 一次判定日) {
        requireNonNull(一次判定日, UrSystemErrorMessages.値がnull.getReplacedMessage("一次判定日"));
        entity.setIchijiHanteiYMD(一次判定日);
        return this;
    }

    /**
     * 一次判定結果を設定します。
     *
     * @param 一次判定結果 一次判定結果
     * @return {@link YokaigoNinteiInterfaceBuilder}
     */
    public YokaigoNinteiInterfaceBuilder set一次判定結果(RString 一次判定結果) {
        requireNonNull(一次判定結果, UrSystemErrorMessages.値がnull.getReplacedMessage("一次判定結果"));
        entity.setIchijiHanteiKekkaCode(一次判定結果);
        return this;
    }

    /**
     * 一次判定結果（認知症加算）を設定します。
     *
     * @param 一次判定結果認知症加算 一次判定結果認知症加算
     * @return {@link YokaigoNinteiInterfaceBuilder}
     */
    public YokaigoNinteiInterfaceBuilder set一次判定結果認知症加算(RString 一次判定結果認知症加算) {
        requireNonNull(一次判定結果認知症加算, UrSystemErrorMessages.値がnull.getReplacedMessage("一次判定結果（認知症加算）"));
        entity.setIchijiHanteiKekkaKasanCode(一次判定結果認知症加算);
        return this;
    }

    /**
     * 審査会資料作成年月日を設定します。
     *
     * @param 審査会資料作成年月日 審査会資料作成年月日
     * @return {@link YokaigoNinteiInterfaceBuilder}
     */
    public YokaigoNinteiInterfaceBuilder set審査会資料作成年月日(FlexibleDate 審査会資料作成年月日) {
        requireNonNull(審査会資料作成年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("審査会資料作成年月日"));
        entity.setShinsakaiShiryoSakuseiYMD(審査会資料作成年月日);
        return this;
    }

    /**
     * 審査会予定年月日を設定します。
     *
     * @param 審査会予定年月日 審査会予定年月日
     * @return {@link YokaigoNinteiInterfaceBuilder}
     */
    public YokaigoNinteiInterfaceBuilder set審査会予定年月日(FlexibleDate 審査会予定年月日) {
        requireNonNull(審査会予定年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("審査会予定年月日"));
        entity.setShinsakaiYoteiYMD(審査会予定年月日);
        return this;
    }

    /**
     * 合議体番号を設定します。
     *
     * @param 合議体番号 合議体番号
     * @return {@link YokaigoNinteiInterfaceBuilder}
     */
    public YokaigoNinteiInterfaceBuilder set合議体番号(int 合議体番号) {
        requireNonNull(合議体番号, UrSystemErrorMessages.値がnull.getReplacedMessage("合議体番号"));
        entity.setGogitaiNo(合議体番号);
        return this;
    }

    /**
     * 二次判定日を設定します。
     *
     * @param 二次判定日 二次判定日
     * @return {@link YokaigoNinteiInterfaceBuilder}
     */
    public YokaigoNinteiInterfaceBuilder set二次判定日(FlexibleDate 二次判定日) {
        requireNonNull(二次判定日, UrSystemErrorMessages.値がnull.getReplacedMessage("二次判定日"));
        entity.setNijiHanteiYMD(二次判定日);
        return this;
    }

    /**
     * 二次判定結果を設定します。
     *
     * @param 二次判定結果 二次判定結果
     * @return {@link YokaigoNinteiInterfaceBuilder}
     */
    public YokaigoNinteiInterfaceBuilder set二次判定結果(RString 二次判定結果) {
        requireNonNull(二次判定結果, UrSystemErrorMessages.値がnull.getReplacedMessage("二次判定結果"));
        entity.setNijiHanteiKekkaCode(二次判定結果);
        return this;
    }

    /**
     * 認定有効開始年月日を設定します。
     *
     * @param 認定有効開始年月日 認定有効開始年月日
     * @return {@link YokaigoNinteiInterfaceBuilder}
     */
    public YokaigoNinteiInterfaceBuilder set認定有効開始年月日(FlexibleDate 認定有効開始年月日) {
        requireNonNull(認定有効開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("認定有効開始年月日"));
        entity.setNinteiYukoKikanStart(認定有効開始年月日);
        return this;
    }

    /**
     * 認定有効終了年月日を設定します。
     *
     * @param 認定有効終了年月日 認定有効終了年月日
     * @return {@link YokaigoNinteiInterfaceBuilder}
     */
    public YokaigoNinteiInterfaceBuilder set認定有効終了年月日(FlexibleDate 認定有効終了年月日) {
        requireNonNull(認定有効終了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("認定有効終了年月日"));
        entity.setNinteiYukoKikanEnd(認定有効終了年月日);
        return this;
    }

    /**
     * サービス変更理由コードを設定します。
     *
     * @param サービス変更理由コード サービス変更理由コード
     * @return {@link YokaigoNinteiInterfaceBuilder}
     */
    public YokaigoNinteiInterfaceBuilder setサービス変更理由コード(RString サービス変更理由コード) {
        requireNonNull(サービス変更理由コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス変更理由コード"));
        entity.setServiceHenkoRiyuCode(サービス変更理由コード);
        return this;
    }

    /**
     * 特定疾病コードを設定します。
     *
     * @param 特定疾病コード 特定疾病コード
     * @return {@link YokaigoNinteiInterfaceBuilder}
     */
    public YokaigoNinteiInterfaceBuilder set特定疾病コード(RString 特定疾病コード) {
        requireNonNull(特定疾病コード, UrSystemErrorMessages.値がnull.getReplacedMessage("特定疾病コード"));
        entity.setTokuteiShippeiCode(特定疾病コード);
        return this;
    }

    /**
     * 障害高齢者自立度を設定します。
     *
     * @param 障害高齢者自立度 障害高齢者自立度
     * @return {@link YokaigoNinteiInterfaceBuilder}
     */
    public YokaigoNinteiInterfaceBuilder set障害高齢者自立度(RString 障害高齢者自立度) {
        requireNonNull(障害高齢者自立度, UrSystemErrorMessages.値がnull.getReplacedMessage("障害高齢者自立度"));
        entity.setShogaiKoreiJiritsudo(障害高齢者自立度);
        return this;
    }

    /**
     * 認知症高齢者自立度を設定します。
     *
     * @param 認知症高齢者自立度 認知症高齢者自立度
     * @return {@link YokaigoNinteiInterfaceBuilder}
     */
    public YokaigoNinteiInterfaceBuilder set認知症高齢者自立度(RString 認知症高齢者自立度) {
        requireNonNull(認知症高齢者自立度, UrSystemErrorMessages.値がnull.getReplacedMessage("認知症高齢者自立度"));
        entity.setNinchishoKoreiJiritsudo(認知症高齢者自立度);
        return this;
    }

    /**
     * 審査会意見を設定します。
     *
     * @param 審査会意見 審査会意見
     * @return {@link YokaigoNinteiInterfaceBuilder}
     */
    public YokaigoNinteiInterfaceBuilder set審査会意見(RString 審査会意見) {
        requireNonNull(審査会意見, UrSystemErrorMessages.値がnull.getReplacedMessage("審査会意見"));
        entity.setShinsakaiIken(審査会意見);
        return this;
    }

    /**
     * 版番号を設定します。
     *
     * @param 版番号 版番号
     * @return {@link YokaigoNinteiInterfaceBuilder}
     */
    public YokaigoNinteiInterfaceBuilder set版番号(RString 版番号) {
        requireNonNull(版番号, UrSystemErrorMessages.値がnull.getReplacedMessage("版番号"));
        entity.setVersionNo(版番号);
        return this;
    }

    /**
     * 一次判定内容を設定します。
     *
     * @param 一次判定内容 一次判定内容
     * @return {@link YokaigoNinteiInterfaceBuilder}
     */
    public YokaigoNinteiInterfaceBuilder set一次判定内容(RString 一次判定内容) {
        requireNonNull(一次判定内容, UrSystemErrorMessages.値がnull.getReplacedMessage("一次判定内容"));
        entity.setIchijiHanteiNaiyo(一次判定内容);
        return this;
    }

    /**
     * 一次判定内容２を設定します。
     *
     * @param 一次判定内容２ 一次判定内容２
     * @return {@link YokaigoNinteiInterfaceBuilder}
     */
    public YokaigoNinteiInterfaceBuilder set一次判定内容２(RString 一次判定内容２) {
        requireNonNull(一次判定内容２, UrSystemErrorMessages.値がnull.getReplacedMessage("一次判定内容２"));
        entity.setIchijiHanteiNaiyo2(一次判定内容２);
        return this;
    }

    /**
     * 前回取込日時を設定します。
     *
     * @param 前回取込日時 前回取込日時
     * @return {@link YokaigoNinteiInterfaceBuilder}
     */
    public YokaigoNinteiInterfaceBuilder set前回取込日時(YMDHMS 前回取込日時) {
        requireNonNull(前回取込日時, UrSystemErrorMessages.値がnull.getReplacedMessage("前回取込日時"));
        entity.setZenTorikomiTimestamp(前回取込日時);
        return this;
    }

    /**
     * 消し込みフラグを設定します。
     *
     * @param 消し込みフラグ 消し込みフラグ
     * @return {@link YokaigoNinteiInterfaceBuilder}
     */
    public YokaigoNinteiInterfaceBuilder set消し込みフラグ(RString 消し込みフラグ) {
        requireNonNull(消し込みフラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("消し込みフラグ"));
        entity.setKeshikomiFlag(消し込みフラグ);
        return this;
    }

    /**
     * 消し込み日時を設定します。
     *
     * @param 消し込み日時 消し込み日時
     * @return {@link YokaigoNinteiInterfaceBuilder}
     */
    public YokaigoNinteiInterfaceBuilder set消し込み日時(YMDHMS 消し込み日時) {
        requireNonNull(消し込み日時, UrSystemErrorMessages.値がnull.getReplacedMessage("消し込み日時"));
        entity.setKeshikomiTimestamp(消し込み日時);
        return this;
    }

    /**
     * 予備項目１を設定します。
     *
     * @param 予備項目１ 予備項目１
     * @return {@link YokaigoNinteiInterfaceBuilder}
     */
    public YokaigoNinteiInterfaceBuilder set予備項目１(RString 予備項目１) {
        requireNonNull(予備項目１, UrSystemErrorMessages.値がnull.getReplacedMessage("予備項目１"));
        entity.setYobiKomoku1(予備項目１);
        return this;
    }

    /**
     * 予備項目２を設定します。
     *
     * @param 予備項目２ 予備項目２
     * @return {@link YokaigoNinteiInterfaceBuilder}
     */
    public YokaigoNinteiInterfaceBuilder set予備項目２(RString 予備項目２) {
        requireNonNull(予備項目２, UrSystemErrorMessages.値がnull.getReplacedMessage("予備項目２"));
        entity.setYobiKomoku2(予備項目２);
        return this;
    }

    /**
     * 予備項目３を設定します。
     *
     * @param 予備項目３ 予備項目３
     * @return {@link YokaigoNinteiInterfaceBuilder}
     */
    public YokaigoNinteiInterfaceBuilder set予備項目３(RString 予備項目３) {
        requireNonNull(予備項目３, UrSystemErrorMessages.値がnull.getReplacedMessage("予備項目３"));
        entity.setYobiKomoku3(予備項目３);
        return this;
    }

    /**
     * 予備項目４を設定します。
     *
     * @param 予備項目４ 予備項目４
     * @return {@link YokaigoNinteiInterfaceBuilder}
     */
    public YokaigoNinteiInterfaceBuilder set予備項目４(RString 予備項目４) {
        requireNonNull(予備項目４, UrSystemErrorMessages.値がnull.getReplacedMessage("予備項目４"));
        entity.setYobiKomoku4(予備項目４);
        return this;
    }

    /**
     * 予備項目５を設定します。
     *
     * @param 予備項目５ 予備項目５
     * @return {@link YokaigoNinteiInterfaceBuilder}
     */
    public YokaigoNinteiInterfaceBuilder set予備項目５(RString 予備項目５) {
        requireNonNull(予備項目５, UrSystemErrorMessages.値がnull.getReplacedMessage("予備項目５"));
        entity.setYobiKomoku5(予備項目５);
        return this;
    }

    /**
     * 予備区分１を設定します。
     *
     * @param 予備区分１ 予備区分１
     * @return {@link YokaigoNinteiInterfaceBuilder}
     */
    public YokaigoNinteiInterfaceBuilder set予備区分１(RString 予備区分１) {
        requireNonNull(予備区分１, UrSystemErrorMessages.値がnull.getReplacedMessage("予備区分１"));
        entity.setYobiKomoku1(予備区分１);
        return this;
    }

    /**
     * 予備区分２を設定します。
     *
     * @param 予備区分２ 予備区分２
     * @return {@link YokaigoNinteiInterfaceBuilder}
     */
    public YokaigoNinteiInterfaceBuilder set予備区分２(RString 予備区分２) {
        requireNonNull(予備区分２, UrSystemErrorMessages.値がnull.getReplacedMessage("予備区分２"));
        entity.setYobiKomoku2(予備区分２);
        return this;
    }

    /**
     * 予備区分３を設定します。
     *
     * @param 予備区分３ 予備区分３
     * @return {@link YokaigoNinteiInterfaceBuilder}
     */
    public YokaigoNinteiInterfaceBuilder set予備区分３(RString 予備区分３) {
        requireNonNull(予備区分３, UrSystemErrorMessages.値がnull.getReplacedMessage("予備区分３"));
        entity.setYobiKomoku3(予備区分３);
        return this;
    }

    /**
     * 予備区分４ 申請区分（法令）コードを設定します。
     *
     * @param 予備区分４ 申請区分（法令）コード 予備区分４ 申請区分（法令）コード
     * @return {@link YokaigoNinteiInterfaceBuilder}
     */
    public YokaigoNinteiInterfaceBuilder set予備区分４コード(RString 予備区分４) {
        requireNonNull(予備区分４, UrSystemErrorMessages.値がnull.getReplacedMessage("予備区分４")
        );
        entity.setYobiKomoku4(予備区分４);
        return this;
    }

    /**
     * 予備区分５を設定します。
     *
     * @param 予備区分５ 予備区分５
     * @return {@link YokaigoNinteiInterfaceBuilder}
     */
    public YokaigoNinteiInterfaceBuilder set予備区分５(RString 予備区分５) {
        requireNonNull(予備区分５, UrSystemErrorMessages.値がnull.getReplacedMessage("予備区分５"));
        entity.setYobiKomoku5(予備区分５);
        return this;
    }

    /**
     * リザーブを設定します。
     *
     * @param リザーブ リザーブ
     * @return {@link YokaigoNinteiInterfaceBuilder}
     */
    public YokaigoNinteiInterfaceBuilder setリザーブ(RString リザーブ) {
        requireNonNull(リザーブ, UrSystemErrorMessages.値がnull.getReplacedMessage("リザーブ"));
        entity.setReserve(リザーブ);
        return this;
    }

    /**
     * {@link YokaigoNinteiInterface}のインスタンスを生成します。
     *
     * @return {@link YokaigoNinteiInterface}のインスタンス
     */
    public YokaigoNinteiInterface build() {
        return new YokaigoNinteiInterface(entity, id);
    }
}
