/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;

/**
 * {@link NijiYoboCheckListHanteiKekka}の編集を行うビルダークラスです。
 */
public class NijiYoboCheckListHanteiKekkaBuilder {

    private final DbT3103NijiYoboCheckListHanteiKekkaEntity entity;
    private final NijiYoboCheckListHanteiKekkaIdentifier id;

    /**
     * {@link DbT3103NijiYoboCheckListHanteiKekkaEntity}より{@link NijiYoboCheckListHanteiKekka}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT3103NijiYoboCheckListHanteiKekkaEntity}
     * @param id {@link NijiYoboCheckListHanteiKekkaIdentifier}
     *
     */
    NijiYoboCheckListHanteiKekkaBuilder(
            DbT3103NijiYoboCheckListHanteiKekkaEntity entity,
            NijiYoboCheckListHanteiKekkaIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

//TODO Key項目のsetterメソッドは削除してください。
//TODO 一緒に置換される値のまとまりで不変なクラスを作成し、その単位でsetterを作る様に見直してください。
    /**
     * 識別コードを設定します。
     *
     * @param 識別コード 識別コード
     * @return {@link NijiYoboCheckListHanteiKekkaBuilder}
     */
    public NijiYoboCheckListHanteiKekkaBuilder set識別コード(ShikibetsuCode 識別コード) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        entity.setShikibetsuCode(識別コード);
        return this;
    }

    /**
     * 被保険者番号を設定します。
     *
     * @param 被保険者番号 被保険者番号
     * @return {@link NijiYoboCheckListHanteiKekkaBuilder}
     */
    public NijiYoboCheckListHanteiKekkaBuilder set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHihokenshaNo(被保険者番号);
        return this;
    }

    /**
     * 受付年月日を設定します。
     *
     * @param 受付年月日 受付年月日
     * @return {@link NijiYoboCheckListHanteiKekkaBuilder}
     */
    public NijiYoboCheckListHanteiKekkaBuilder set受付年月日(FlexibleDate 受付年月日) {
        requireNonNull(受付年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("受付年月日"));
        entity.setUketsukeYMD(受付年月日);
        return this;
    }

    /**
     * 履歴番号を設定します。
     *
     * @param 履歴番号 履歴番号
     * @return {@link NijiYoboCheckListHanteiKekkaBuilder}
     */
    public NijiYoboCheckListHanteiKekkaBuilder set履歴番号(Decimal 履歴番号) {
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        entity.setRirekiNo(履歴番号);
        return this;
    }

    /**
     * 点数・生活機能全般を設定します。
     *
     * @param 点数・生活機能全般 点数・生活機能全般
     * @return {@link NijiYoboCheckListHanteiKekkaBuilder}
     */
    public NijiYoboCheckListHanteiKekkaBuilder set点数・生活機能全般(Decimal 点数・生活機能全般) {
        requireNonNull(点数・生活機能全般, UrSystemErrorMessages.値がnull.getReplacedMessage("点数・生活機能全般"));
        entity.setTensu_SeikatsuKinoZenpan(点数・生活機能全般);
        return this;
    }

    /**
     * 点数・運動器機能を設定します。
     *
     * @param 点数・運動器機能 点数・運動器機能
     * @return {@link NijiYoboCheckListHanteiKekkaBuilder}
     */
    public NijiYoboCheckListHanteiKekkaBuilder set点数・運動器機能(Decimal 点数・運動器機能) {
        requireNonNull(点数・運動器機能, UrSystemErrorMessages.値がnull.getReplacedMessage("点数・運動器機能"));
        entity.setTensu_UndokiKino(点数・運動器機能);
        return this;
    }

    /**
     * 点数・栄養を設定します。
     *
     * @param 点数・栄養 点数・栄養
     * @return {@link NijiYoboCheckListHanteiKekkaBuilder}
     */
    public NijiYoboCheckListHanteiKekkaBuilder set点数・栄養(Decimal 点数・栄養) {
        requireNonNull(点数・栄養, UrSystemErrorMessages.値がnull.getReplacedMessage("点数・栄養"));
        entity.setTensu_Eiyo(点数・栄養);
        return this;
    }

    /**
     * 点数・口腔を設定します。
     *
     * @param 点数・口腔 点数・口腔
     * @return {@link NijiYoboCheckListHanteiKekkaBuilder}
     */
    public NijiYoboCheckListHanteiKekkaBuilder set点数・口腔(Decimal 点数・口腔) {
        requireNonNull(点数・口腔, UrSystemErrorMessages.値がnull.getReplacedMessage("点数・口腔"));
        entity.setTensu_Koku(点数・口腔);
        return this;
    }

    /**
     * 点数・閉じこもりを設定します。
     *
     * @param 点数・閉じこもり 点数・閉じこもり
     * @return {@link NijiYoboCheckListHanteiKekkaBuilder}
     */
    public NijiYoboCheckListHanteiKekkaBuilder set点数・閉じこもり(Decimal 点数・閉じこもり) {
        requireNonNull(点数・閉じこもり, UrSystemErrorMessages.値がnull.getReplacedMessage("点数・閉じこもり"));
        entity.setTensu_Tojikomori(点数・閉じこもり);
        return this;
    }

    /**
     * 点数・認知能力を設定します。
     *
     * @param 点数・認知能力 点数・認知能力
     * @return {@link NijiYoboCheckListHanteiKekkaBuilder}
     */
    public NijiYoboCheckListHanteiKekkaBuilder set点数・認知能力(Decimal 点数・認知能力) {
        requireNonNull(点数・認知能力, UrSystemErrorMessages.値がnull.getReplacedMessage("点数・認知能力"));
        entity.setTensu_NinchiNoryoku(点数・認知能力);
        return this;
    }

    /**
     * 点数・うつを設定します。
     *
     * @param 点数・うつ 点数・うつ
     * @return {@link NijiYoboCheckListHanteiKekkaBuilder}
     */
    public NijiYoboCheckListHanteiKekkaBuilder set点数・うつ(Decimal 点数・うつ) {
        requireNonNull(点数・うつ, UrSystemErrorMessages.値がnull.getReplacedMessage("点数・うつ"));
        entity.setTensu_Utsu(点数・うつ);
        return this;
    }

    /**
     * 支援必要性・生活機能全般を設定します。
     *
     * @param 支援必要性・生活機能全般 支援必要性・生活機能全般
     * @return {@link NijiYoboCheckListHanteiKekkaBuilder}
     */
    public NijiYoboCheckListHanteiKekkaBuilder set支援必要性・生活機能全般(Decimal 支援必要性・生活機能全般) {
        requireNonNull(支援必要性・生活機能全般, UrSystemErrorMessages.値がnull.getReplacedMessage("支援必要性・生活機能全般"));
        entity.setShien_SeikatsuKinoZenpan(支援必要性・生活機能全般);
        return this;
    }

    /**
     * 支援必要性・運動器機能を設定します。
     *
     * @param 支援必要性・運動器機能 支援必要性・運動器機能
     * @return {@link NijiYoboCheckListHanteiKekkaBuilder}
     */
    public NijiYoboCheckListHanteiKekkaBuilder set支援必要性・運動器機能(Decimal 支援必要性・運動器機能) {
        requireNonNull(支援必要性・運動器機能, UrSystemErrorMessages.値がnull.getReplacedMessage("支援必要性・運動器機能"));
        entity.setShien_UndokiKino(支援必要性・運動器機能);
        return this;
    }

    /**
     * 支援必要性・栄養を設定します。
     *
     * @param 支援必要性・栄養 支援必要性・栄養
     * @return {@link NijiYoboCheckListHanteiKekkaBuilder}
     */
    public NijiYoboCheckListHanteiKekkaBuilder set支援必要性・栄養(Decimal 支援必要性・栄養) {
        requireNonNull(支援必要性・栄養, UrSystemErrorMessages.値がnull.getReplacedMessage("支援必要性・栄養"));
        entity.setShien_Eiyo(支援必要性・栄養);
        return this;
    }

    /**
     * 支援必要性・口腔を設定します。
     *
     * @param 支援必要性・口腔 支援必要性・口腔
     * @return {@link NijiYoboCheckListHanteiKekkaBuilder}
     */
    public NijiYoboCheckListHanteiKekkaBuilder set支援必要性・口腔(Decimal 支援必要性・口腔) {
        requireNonNull(支援必要性・口腔, UrSystemErrorMessages.値がnull.getReplacedMessage("支援必要性・口腔"));
        entity.setShien_Koku(支援必要性・口腔);
        return this;
    }

    /**
     * 支援必要性・閉じこもりを設定します。
     *
     * @param 支援必要性・閉じこもり 支援必要性・閉じこもり
     * @return {@link NijiYoboCheckListHanteiKekkaBuilder}
     */
    public NijiYoboCheckListHanteiKekkaBuilder set支援必要性・閉じこもり(Decimal 支援必要性・閉じこもり) {
        requireNonNull(支援必要性・閉じこもり, UrSystemErrorMessages.値がnull.getReplacedMessage("支援必要性・閉じこもり"));
        entity.setShien_Tojikomori(支援必要性・閉じこもり);
        return this;
    }

    /**
     * 支援必要性・認知能力を設定します。
     *
     * @param 支援必要性・認知能力 支援必要性・認知能力
     * @return {@link NijiYoboCheckListHanteiKekkaBuilder}
     */
    public NijiYoboCheckListHanteiKekkaBuilder set支援必要性・認知能力(Decimal 支援必要性・認知能力) {
        requireNonNull(支援必要性・認知能力, UrSystemErrorMessages.値がnull.getReplacedMessage("支援必要性・認知能力"));
        entity.setShien_NinchiNoryoku(支援必要性・認知能力);
        return this;
    }

    /**
     * 支援必要性・うつを設定します。
     *
     * @param 支援必要性・うつ 支援必要性・うつ
     * @return {@link NijiYoboCheckListHanteiKekkaBuilder}
     */
    public NijiYoboCheckListHanteiKekkaBuilder set支援必要性・うつ(Decimal 支援必要性・うつ) {
        requireNonNull(支援必要性・うつ, UrSystemErrorMessages.値がnull.getReplacedMessage("支援必要性・うつ"));
        entity.setShien_Utsu(支援必要性・うつ);
        return this;
    }

    /**
     * 二次予防・主観的健康感を設定します。
     *
     * @param 二次予防・主観的健康感 二次予防・主観的健康感
     * @return {@link NijiYoboCheckListHanteiKekkaBuilder}
     */
    public NijiYoboCheckListHanteiKekkaBuilder set二次予防・主観的健康感(RString 二次予防・主観的健康感) {
        requireNonNull(二次予防・主観的健康感, UrSystemErrorMessages.値がnull.getReplacedMessage("二次予防・主観的健康感"));
        entity.setNijiYobo_ShukantekiKenkouKan(二次予防・主観的健康感);
        return this;
    }

    /**
     * {@link NijiYoboCheckListHanteiKekka}のインスタンスを生成します。
     *
     * @return {@link NijiYoboCheckListHanteiKekka}のインスタンス
     */
    public NijiYoboCheckListHanteiKekka build() {
        return new NijiYoboCheckListHanteiKekka(entity, id);
    }
}
