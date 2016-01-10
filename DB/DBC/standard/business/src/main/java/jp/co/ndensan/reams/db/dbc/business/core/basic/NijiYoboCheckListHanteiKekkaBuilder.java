/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3103NijiYoboCheckListHanteiKekkaEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

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
//    public NijiYoboCheckListHanteiKekkaBuilder set識別コード(ShikibetsuCode 識別コード) {
//        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
//        entity.setShikibetsuCode(識別コード);
//        return this;
//    }

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
    public NijiYoboCheckListHanteiKekkaBuilder set履歴番号(int 履歴番号) {
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        entity.setRirekiNo(履歴番号);
        return this;
    }

    /**
     * 点数_生活機能全般を設定します。
     *
     * @param 点数_生活機能全般 点数_生活機能全般
     * @return {@link NijiYoboCheckListHanteiKekkaBuilder}
     */
    public NijiYoboCheckListHanteiKekkaBuilder set点数_生活機能全般(Decimal 点数_生活機能全般) {
        requireNonNull(点数_生活機能全般, UrSystemErrorMessages.値がnull.getReplacedMessage("点数_生活機能全般"));
        entity.setTensu_SeikatsuKinoZenpan(点数_生活機能全般);
        return this;
    }

    /**
     * 点数_運動器機能を設定します。
     *
     * @param 点数_運動器機能 点数_運動器機能
     * @return {@link NijiYoboCheckListHanteiKekkaBuilder}
     */
    public NijiYoboCheckListHanteiKekkaBuilder set点数_運動器機能(Decimal 点数_運動器機能) {
        requireNonNull(点数_運動器機能, UrSystemErrorMessages.値がnull.getReplacedMessage("点数_運動器機能"));
        entity.setTensu_UndokiKino(点数_運動器機能);
        return this;
    }

    /**
     * 点数_栄養を設定します。
     *
     * @param 点数_栄養 点数_栄養
     * @return {@link NijiYoboCheckListHanteiKekkaBuilder}
     */
    public NijiYoboCheckListHanteiKekkaBuilder set点数_栄養(Decimal 点数_栄養) {
        requireNonNull(点数_栄養, UrSystemErrorMessages.値がnull.getReplacedMessage("点数_栄養"));
        entity.setTensu_Eiyo(点数_栄養);
        return this;
    }

    /**
     * 点数_口腔を設定します。
     *
     * @param 点数_口腔 点数_口腔
     * @return {@link NijiYoboCheckListHanteiKekkaBuilder}
     */
    public NijiYoboCheckListHanteiKekkaBuilder set点数_口腔(Decimal 点数_口腔) {
        requireNonNull(点数_口腔, UrSystemErrorMessages.値がnull.getReplacedMessage("点数_口腔"));
        entity.setTensu_Koku(点数_口腔);
        return this;
    }

    /**
     * 点数_閉じこもりを設定します。
     *
     * @param 点数_閉じこもり 点数_閉じこもり
     * @return {@link NijiYoboCheckListHanteiKekkaBuilder}
     */
    public NijiYoboCheckListHanteiKekkaBuilder set点数_閉じこもり(Decimal 点数_閉じこもり) {
        requireNonNull(点数_閉じこもり, UrSystemErrorMessages.値がnull.getReplacedMessage("点数_閉じこもり"));
        entity.setTensu_Tojikomori(点数_閉じこもり);
        return this;
    }

    /**
     * 点数_認知能力を設定します。
     *
     * @param 点数_認知能力 点数_認知能力
     * @return {@link NijiYoboCheckListHanteiKekkaBuilder}
     */
    public NijiYoboCheckListHanteiKekkaBuilder set点数_認知能力(Decimal 点数_認知能力) {
        requireNonNull(点数_認知能力, UrSystemErrorMessages.値がnull.getReplacedMessage("点数_認知能力"));
        entity.setTensu_NinchiNoryoku(点数_認知能力);
        return this;
    }

    /**
     * 点数_うつを設定します。
     *
     * @param 点数_うつ 点数_うつ
     * @return {@link NijiYoboCheckListHanteiKekkaBuilder}
     */
    public NijiYoboCheckListHanteiKekkaBuilder set点数_うつ(Decimal 点数_うつ) {
        requireNonNull(点数_うつ, UrSystemErrorMessages.値がnull.getReplacedMessage("点数_うつ"));
        entity.setTensu_Utsu(点数_うつ);
        return this;
    }

    /**
     * 支援必要性_生活機能全般を設定します。
     *
     * @param 支援必要性_生活機能全般 支援必要性_生活機能全般
     * @return {@link NijiYoboCheckListHanteiKekkaBuilder}
     */
    public NijiYoboCheckListHanteiKekkaBuilder set支援必要性_生活機能全般(int 支援必要性_生活機能全般) {
        requireNonNull(支援必要性_生活機能全般, UrSystemErrorMessages.値がnull.getReplacedMessage("支援必要性_生活機能全般"));
        entity.setShien_SeikatsuKinoZenpan(支援必要性_生活機能全般);
        return this;
    }

    /**
     * 支援必要性_運動器機能を設定します。
     *
     * @param 支援必要性_運動器機能 支援必要性_運動器機能
     * @return {@link NijiYoboCheckListHanteiKekkaBuilder}
     */
    public NijiYoboCheckListHanteiKekkaBuilder set支援必要性_運動器機能(int 支援必要性_運動器機能) {
        requireNonNull(支援必要性_運動器機能, UrSystemErrorMessages.値がnull.getReplacedMessage("支援必要性_運動器機能"));
        entity.setShien_UndokiKino(支援必要性_運動器機能);
        return this;
    }

    /**
     * 支援必要性_栄養を設定します。
     *
     * @param 支援必要性_栄養 支援必要性_栄養
     * @return {@link NijiYoboCheckListHanteiKekkaBuilder}
     */
    public NijiYoboCheckListHanteiKekkaBuilder set支援必要性_栄養(int 支援必要性_栄養) {
        requireNonNull(支援必要性_栄養, UrSystemErrorMessages.値がnull.getReplacedMessage("支援必要性_栄養"));
        entity.setShien_Eiyo(支援必要性_栄養);
        return this;
    }

    /**
     * 支援必要性_口腔を設定します。
     *
     * @param 支援必要性_口腔 支援必要性_口腔
     * @return {@link NijiYoboCheckListHanteiKekkaBuilder}
     */
    public NijiYoboCheckListHanteiKekkaBuilder set支援必要性_口腔(int 支援必要性_口腔) {
        requireNonNull(支援必要性_口腔, UrSystemErrorMessages.値がnull.getReplacedMessage("支援必要性_口腔"));
        entity.setShien_Koku(支援必要性_口腔);
        return this;
    }

    /**
     * 支援必要性_閉じこもりを設定します。
     *
     * @param 支援必要性_閉じこもり 支援必要性_閉じこもり
     * @return {@link NijiYoboCheckListHanteiKekkaBuilder}
     */
    public NijiYoboCheckListHanteiKekkaBuilder set支援必要性_閉じこもり(int 支援必要性_閉じこもり) {
        requireNonNull(支援必要性_閉じこもり, UrSystemErrorMessages.値がnull.getReplacedMessage("支援必要性_閉じこもり"));
        entity.setShien_Tojikomori(支援必要性_閉じこもり);
        return this;
    }

    /**
     * 支援必要性_認知能力を設定します。
     *
     * @param 支援必要性_認知能力 支援必要性_認知能力
     * @return {@link NijiYoboCheckListHanteiKekkaBuilder}
     */
    public NijiYoboCheckListHanteiKekkaBuilder set支援必要性_認知能力(int 支援必要性_認知能力) {
        requireNonNull(支援必要性_認知能力, UrSystemErrorMessages.値がnull.getReplacedMessage("支援必要性_認知能力"));
        entity.setShien_NinchiNoryoku(支援必要性_認知能力);
        return this;
    }

    /**
     * 支援必要性_うつを設定します。
     *
     * @param 支援必要性_うつ 支援必要性_うつ
     * @return {@link NijiYoboCheckListHanteiKekkaBuilder}
     */
    public NijiYoboCheckListHanteiKekkaBuilder set支援必要性_うつ(int 支援必要性_うつ) {
        requireNonNull(支援必要性_うつ, UrSystemErrorMessages.値がnull.getReplacedMessage("支援必要性_うつ"));
        entity.setShien_Utsu(支援必要性_うつ);
        return this;
    }

    /**
     * 二次予防_主観的健康感を設定します。
     *
     * @param 二次予防_主観的健康感 二次予防_主観的健康感
     * @return {@link NijiYoboCheckListHanteiKekkaBuilder}
     */
    public NijiYoboCheckListHanteiKekkaBuilder set二次予防_主観的健康感(RString 二次予防_主観的健康感) {
        requireNonNull(二次予防_主観的健康感, UrSystemErrorMessages.値がnull.getReplacedMessage("二次予防_主観的健康感"));
        entity.setNijiYobo_ShukantekiKenkouKan(二次予防_主観的健康感);
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
