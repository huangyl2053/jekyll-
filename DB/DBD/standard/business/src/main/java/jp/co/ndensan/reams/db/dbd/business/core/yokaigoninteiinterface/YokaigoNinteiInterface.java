/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.yokaigoninteiinterface;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4003YokaigoNinteiInterfaceEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.ParentModelBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 要介護認定インターフェース情報を管理するクラスです。
 *
 * @reamsid_L DBD-9999-013 chenxin
 */
public class YokaigoNinteiInterface extends
        ParentModelBase<YokaigoNinteiInterfaceIdentifier, DbT4003YokaigoNinteiInterfaceEntity, YokaigoNinteiInterface> implements Serializable {

//TODO NetBeansの機能を使って必ずequalsとhashCodeを追加してください。
    private final DbT4003YokaigoNinteiInterfaceEntity entity;
    private final YokaigoNinteiInterfaceIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 要介護認定インターフェース情報の新規作成時に使用します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 被保険者番号 被保険者番号
     * @param 取込日時 取込日時
     * @param 申請種別コード 申請種別コード
     * @param 取下区分コード 取下区分コード
     * @param 認定申請日 認定申請日
     * @param 一次判定日 一次判定日
     * @param 一次判定結果 一次判定結果
     * @param 二次判定日 二次判定日
     * @param 二次判定結果 二次判定結果
     * @param 認定有効開始年月日 認定有効開始年月日
     * @param 認定有効終了年月日 認定有効終了年月日
     * @param 予備区分４ 予備区分４
     */
    public YokaigoNinteiInterface(ShinseishoKanriNo 申請書管理番号,
            HihokenshaNo 被保険者番号,
            RString 取込日時,
            RString 申請種別コード,
            RString 取下区分コード,
            FlexibleDate 認定申請日,
            FlexibleDate 一次判定日,
            RString 一次判定結果,
            FlexibleDate 二次判定日,
            RString 二次判定結果,
            FlexibleDate 認定有効開始年月日,
            FlexibleDate 認定有効終了年月日,
            RString 予備区分４
    ) {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(取込日時, UrSystemErrorMessages.値がnull.getReplacedMessage("取込日時"));
        requireNonNull(申請種別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("申請種別コード"));
        requireNonNull(取下区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("取下区分コード"));
        requireNonNull(認定申請日, UrSystemErrorMessages.値がnull.getReplacedMessage("認定申請日"));
        requireNonNull(一次判定日, UrSystemErrorMessages.値がnull.getReplacedMessage("一次判定日"));
        requireNonNull(一次判定結果, UrSystemErrorMessages.値がnull.getReplacedMessage("一次判定結果"));
        requireNonNull(二次判定日, UrSystemErrorMessages.値がnull.getReplacedMessage("二次判定日"));
        requireNonNull(二次判定結果, UrSystemErrorMessages.値がnull.getReplacedMessage("二次判定結果"));
        requireNonNull(認定有効開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("認定有効開始年月日"));
        requireNonNull(認定有効終了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("認定有効終了年月日"));
        requireNonNull(予備区分４, UrSystemErrorMessages.値がnull.getReplacedMessage("予備区分４"));
        this.entity = new DbT4003YokaigoNinteiInterfaceEntity();
        this.entity.setShinseishoKanriNo(申請書管理番号);
        this.entity.setHihokenshaNo(被保険者番号);
        this.entity.setTorikomiTimestamp(取込日時);
        this.entity.setShinseiShubetsuCode(申請種別コード);
        this.entity.setTorisageKubunCode(取下区分コード);
        this.entity.setShinseiYMD(認定申請日);
        this.entity.setIchijiHanteiYMD(一次判定日);
        this.entity.setIchijiHanteiKekkaCode(一次判定結果);
        this.entity.setNijiHanteiYMD(二次判定日);
        this.entity.setNijiHanteiKekkaCode(二次判定結果);
        this.entity.setNinteiYukoKikanStart(認定有効開始年月日);
        this.entity.setNinteiYukoKikanEnd(認定有効終了年月日);
        this.entity.setYobiKomoku4(予備区分４);
        this.id = new YokaigoNinteiInterfaceIdentifier(
                申請書管理番号,
                被保険者番号,
                取込日時,
                申請種別コード,
                取下区分コード,
                認定申請日,
                一次判定日,
                一次判定結果,
                二次判定日,
                二次判定結果,
                認定有効開始年月日,
                認定有効終了年月日,
                予備区分４
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT4003YokaigoNinteiInterfaceEntity}より{@link YokaigoNinteiInterface}を生成します。
     *
     * @param entity DBより取得した{@link DbT4003YokaigoNinteiInterfaceEntity}
     */
    public YokaigoNinteiInterface(DbT4003YokaigoNinteiInterfaceEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定インターフェース情報"));
        this.id = new YokaigoNinteiInterfaceIdentifier(
                entity.getShinseishoKanriNo(),
                entity.getHihokenshaNo(),
                entity.getTorikomiTimestamp(),
                entity.getShinseiShubetsuCode(),
                entity.getTorisageKubunCode(),
                entity.getShinseiYMD(),
                entity.getIchijiHanteiYMD(),
                entity.getIchijiHanteiKekkaCode(),
                entity.getNijiHanteiYMD(),
                entity.getNijiHanteiKekkaCode(),
                entity.getNinteiYukoKikanStart(),
                entity.getNinteiYukoKikanEnd(),
                entity.getYobiKomoku4());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT4003YokaigoNinteiInterfaceEntity}
     * @param id {@link YokaigoNinteiInterfaceIdentifier}
     */
    YokaigoNinteiInterface(
            DbT4003YokaigoNinteiInterfaceEntity entity,
            YokaigoNinteiInterfaceIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
    }

//TODO getterを見直してください。意味のある単位でValueObjectを作成して公開してください。
    /**
     * Reamsコンフィグから読み取った団体(市町村)コードを返します。
     *
     * @return Reamsコンフィグから読み取った団体(市町村)コード
     */
    public RString getReamsコンフィグから読み取った団体市町村コード() {
        return entity.getInsertDantaiCd();
    }

    /**
     * 行挿入日時を返します。
     *
     * @return 行挿入日時
     */
//    public RDateTime get行挿入日時() {
//        return entity.getInsertTimestamp();
//    }
//
//    /**
//     * 行挿入したReamsログインidを返します。
//     *
//     * @return 行挿入したReamsログインid
//     */
//    public RString get行挿入したReamsログインid() {
//        return entity.getInsertReamsLoginId();
//    }
//
//    /**
//     * 行挿入時の接続コンテキストを返します。
//     *
//     * @return 行挿入時の接続コンテキスト
//     */
//    public UUID get行挿入時の接続コンテキスト() {
//        return entity.getInsertContextId();
//    }
    /**
     * 論理削除行を返します。
     *
     * @return 論理削除行
     */
    public boolean get論理削除行() {
        return entity.getIsDeleted();
    }

    /**
     * Update回数を返します。
     *
     * @return Update回数
     */
//    public int getUpdate回数() {
//        return entity.getUpdateCount();
//    }
//
//    /**
//     * 最終Update日時を返します。
//     *
//     * @return 最終Update日時
//     */
//    public RDateTime get最終Update日時() {
//        return entity.getLastUpdateTimestamp();
//    }
//
//    /**
//     * 最後にupdateしたReamsログインidを返します。
//     *
//     * @return 最後にupdateしたReamsログインid
//     */
//    public RString get最後にupdateしたReamsログインid() {
//        return entity.getLastUpdateReamsLoginId();
//    }
    /**
     * 申請書管理番号を返します。
     *
     * @return 申請書管理番号
     */
    public ShinseishoKanriNo get申請書管理番号() {
        return entity.getShinseishoKanriNo();
    }

    /**
     * 被保険者番号を返します。
     *
     * @return 被保険者番号
     */
    public HihokenshaNo get被保険者番号() {
        return entity.getHihokenshaNo();
    }

    /**
     * 履歴番号を返します。
     *
     * @return 履歴番号
     */
    public RString get履歴番号() {
        return entity.getRirekiNo();
    }

    /**
     * 取込日時を返します。
     *
     * @return 取込日時
     */
    public RString get取込日時() {
        return entity.getTorikomiTimestamp();
    }

    /**
     * 取込区分を返します。
     *
     * @return 取込区分
     */
    public YMDHMS get取込区分() {
        return entity.getTorikomiKubun();
    }

    /**
     * 申請種別コードを返します。
     *
     * @return 申請種別コード
     */
    public RString get申請種別コード() {
        return entity.getShinseiShubetsuCode();
    }

    /**
     * 取下区分コードを返します。
     *
     * @return 取下区分コード
     */
    public RString get取下区分コード() {
        return entity.getTorisageKubunCode();
    }

    /**
     * 認定申請日を返します。
     *
     * @return 認定申請日
     */
    public FlexibleDate get認定申請日() {
        return entity.getShinseiYMD();
    }

    /**
     * 医療機関コードを返します。
     *
     * @return 医療機関コード
     */
    public RString get医療機関コード() {
        return entity.getIryoKikanCode();
    }

    /**
     * 主治医コードを返します。
     *
     * @return 主治医コード
     */
    public RString get主治医コード() {
        return entity.getShujiiCode();
    }

    /**
     * 意見書依頼年月日を返します。
     *
     * @return 意見書依頼年月日
     */
    public FlexibleDate get意見書依頼年月日() {
        return entity.getIkenshoIraiYMD();
    }

    /**
     * 意見書取寄せ年月日を返します。
     *
     * @return 意見書取寄せ年月日
     */
    public FlexibleDate get意見書取寄せ年月日() {
        return entity.getIkenshoToriyoseYMD();
    }

    /**
     * 調査委託年月日を返します。
     *
     * @return 調査委託年月日
     */
    public FlexibleDate get調査委託年月日() {
        return entity.getChosaItakuYMD();
    }

    /**
     * 調査終了年月日を返します。
     *
     * @return 調査終了年月日
     */
    public FlexibleDate get調査終了年月日() {
        return entity.getChosaShuryoYMD();
    }

    /**
     * 調査委託先コードを返します。
     *
     * @return 調査委託先コード
     */
    public JigyoshaNo get調査委託先コード() {
        return entity.getChosaItakusakiCode();
    }

    /**
     * 調査員コードを返します。
     *
     * @return 調査員コード
     */
    public RString get調査員コード() {
        return entity.getChosainCode();
    }

    /**
     * 一次判定日を返します。
     *
     * @return 一次判定日
     */
    public FlexibleDate get一次判定日() {
        return entity.getIchijiHanteiYMD();
    }

    /**
     * 一次判定結果を返します。
     *
     * @return 一次判定結果
     */
    public RString get一次判定結果() {
        return entity.getIchijiHanteiKekkaCode();
    }

    /**
     * 一次判定結果（認知症加算）を返します。
     *
     * @return 一次判定結果（認知症加算）
     */
    public RString get一次判定結果認知症加算() {
        return entity.getIchijiHanteiKekkaKasanCode();
    }

    /**
     * 審査会資料作成年月日を返します。
     *
     * @return 審査会資料作成年月日
     */
    public FlexibleDate get審査会資料作成年月日() {
        return entity.getShinsakaiShiryoSakuseiYMD();
    }

    /**
     * 審査会予定年月日を返します。
     *
     * @return 審査会予定年月日
     */
    public FlexibleDate get審査会予定年月日() {
        return entity.getShinsakaiYoteiYMD();
    }

    /**
     * 合議体番号を返します。
     *
     * @return 合議体番号
     */
    public int get合議体番号() {
        return entity.getGogitaiNo();
    }

    /**
     * 二次判定日を返します。
     *
     * @return 二次判定日
     */
    public FlexibleDate get二次判定日() {
        return entity.getNijiHanteiYMD();
    }

    /**
     * 二次判定結果を返します。
     *
     * @return 二次判定結果
     */
    public RString get二次判定結果() {
        return entity.getNijiHanteiKekkaCode();
    }

    /**
     * 認定有効開始年月日を返します。
     *
     * @return 認定有効開始年月日
     */
    public FlexibleDate get認定有効開始年月日() {
        return entity.getNinteiYukoKikanStart();
    }

    /**
     * 認定有効終了年月日を返します。
     *
     * @return 認定有効終了年月日
     */
    public FlexibleDate get認定有効終了年月日() {
        return entity.getNinteiYukoKikanEnd();
    }

    /**
     * サービス変更理由コードを返します。
     *
     * @return サービス変更理由コード
     */
    public RString getサービス変更理由コード() {
        return entity.getServiceHenkoRiyuCode();
    }

    /**
     * 特定疾病コードを返します。
     *
     * @return 特定疾病コード
     */
    public RString get特定疾病コード() {
        return entity.getTokuteiShippeiCode();
    }

    /**
     * 障害高齢者自立度を返します。
     *
     * @return 障害高齢者自立度
     */
    public RString get障害高齢者自立度() {
        return entity.getShogaiKoreiJiritsudo();
    }

    /**
     * 認知症高齢者自立度を返します。
     *
     * @return 認知症高齢者自立度
     */
    public RString get認知症高齢者自立度() {
        return entity.getNinchishoKoreiJiritsudo();
    }

    /**
     * 審査会意見を返します。
     *
     * @return 審査会意見
     */
    public RString get審査会意見() {
        return entity.getShinsakaiIken();
    }

    /**
     * 版番号を返します。
     *
     * @return 版番号
     */
    public RString get版番号() {
        return entity.getVersionNo();
    }

    /**
     * 一次判定内容を返します。
     *
     * @return 一次判定内容
     */
    public RString get一次判定内容() {
        return entity.getIchijiHanteiNaiyo();
    }

    /**
     * 一次判定内容２を返します。
     *
     * @return 一次判定内容２
     */
    public RString get一次判定内容２() {
        return entity.getIchijiHanteiNaiyo2();
    }

    /**
     * 前回取込日時を返します。
     *
     * @return 前回取込日時
     */
    public YMDHMS get前回取込日時() {
        return entity.getZenTorikomiTimestamp();
    }

    /**
     * 消し込みフラグを返します。
     *
     * @return 消し込みフラグ
     */
    public RString get消し込みフラグ() {
        return entity.getKeshikomiFlag();
    }

    /**
     * 消し込み日時を返します。
     *
     * @return 消し込み日時
     */
    public YMDHMS get消し込み日時() {
        return entity.getKeshikomiTimestamp();
    }

    /**
     * 予備項目１を返します。
     *
     * @return 予備項目１
     */
    public RString get予備項目１() {
        return entity.getYobiKomoku1();
    }

    /**
     * 予備項目２を返します。
     *
     * @return 予備項目２
     */
    public RString get予備項目２() {
        return entity.getYobiKomoku2();
    }

    /**
     * 予備項目３を返します。
     *
     * @return 予備項目３
     */
    public RString get予備項目３() {
        return entity.getYobiKomoku3();
    }

    /**
     * 予備項目４を返します。
     *
     * @return 予備項目４
     */
    public RString get予備項目４() {
        return entity.getYobiKomoku4();
    }

    /**
     * 予備項目５を返します。
     *
     * @return 予備項目５
     */
    public RString get予備項目５() {
        return entity.getYobiKomoku5();
    }

    /**
     * 予備区分１を返します。
     *
     * @return 予備区分１
     */
    public RString get予備区分１() {
        return entity.getYobiKomoku1();
    }

    /**
     * 予備区分２を返します。
     *
     * @return 予備区分２
     */
    public RString get予備区分２() {
        return entity.getYobiKomoku2();
    }

    /**
     * 予備区分３を返します。
     *
     * @return 予備区分３
     */
    public RString get予備区分３() {
        return entity.getYobiKomoku3();
    }

    /**
     * 予備区分４ 申請区分（法令）コードを返します。
     *
     * @return 予備区分４ 申請区分（法令）コード
     */
    public RString get予備区分４() {
        return entity.getYobiKomoku4();
    }

    /**
     * 予備区分５を返します。
     *
     * @return 予備区分５
     */
    public RString get予備区分５() {
        return entity.getYobiKomoku5();
    }

    /**
     * リザーブを返します。
     *
     * @return リザーブ
     */
    public RString getリザーブ() {
        return entity.getReserve();
    }

    /**
     * {@link DbT4003YokaigoNinteiInterfaceEntity}のクローンを返します。
     *
     * @return {@link DbT4003YokaigoNinteiInterfaceEntity}のクローン
     */
    @Override
    public DbT4003YokaigoNinteiInterfaceEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 要介護認定インターフェース情報の識別子{@link YokaigoNinteiInterfaceIdentifier}を返します。
     *
     * @return 要介護認定インターフェース情報の識別子{@link YokaigoNinteiInterfaceIdentifier}
     */
    @Override
    public YokaigoNinteiInterfaceIdentifier identifier() {
        return this.id;
    }

    /**
     * 要介護認定インターフェース情報のみを変更対象とします。<br/> {@link DbT4003YokaigoNinteiInterfaceEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link YokaigoNinteiInterface}
     */
    @Override
    public YokaigoNinteiInterface modifiedModel() {
        DbT4003YokaigoNinteiInterfaceEntity modifiedEntity = entity.clone();
        if (modifiedEntity.getState().equals(EntityDataState.Unchanged)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new YokaigoNinteiInterface(
                modifiedEntity, id);
    }

    /**
     * 保持する要介護認定インターフェース情報を削除対象とします。<br/> {@link DbT4003YokaigoNinteiInterfaceEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link YokaigoNinteiInterface}
     */
    @Override
    public YokaigoNinteiInterface deleted() {
        DbT4003YokaigoNinteiInterfaceEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new YokaigoNinteiInterface(deletedEntity, id);
    }

    /**
     * {@link YokaigoNinteiInterface}のシリアライズ形式を提供します。
     *
     * @return {@link YokaigoNinteiInterface}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    @Override
    public boolean hasChanged() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static final class _SerializationProxy implements Serializable {

//        private static final long serialVersionUID = // TODO serialVersionUIDを生成してください
        private final DbT4003YokaigoNinteiInterfaceEntity entity;
        private final YokaigoNinteiInterfaceIdentifier id;

        private _SerializationProxy(DbT4003YokaigoNinteiInterfaceEntity entity, YokaigoNinteiInterfaceIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new YokaigoNinteiInterface(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public YokaigoNinteiInterfaceBuilder createBuilderForEdit() {
        return new YokaigoNinteiInterfaceBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
