/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbu.entity.db.basic.DbT7021JigyoHokokuTokeiDataEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * {@link JigyoHokokuTokeiData}の編集を行うビルダークラスです。
 *
 * @reamsid_L DBU-9999-022 wangkanglei
 */
public class JigyoHokokuTokeiDataBuilder {

    private final DbT7021JigyoHokokuTokeiDataEntity entity;
    private final JigyoHokokuTokeiDataIdentifier id;

    /**
     * {@link DbT7021JigyoHokokuTokeiDataEntity}より{@link JigyoHokokuTokeiData}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT7021JigyoHokokuTokeiDataEntity}
     * @param id {@link JigyoHokokuTokeiDataIdentifier}
     *
     */
    JigyoHokokuTokeiDataBuilder(
            DbT7021JigyoHokokuTokeiDataEntity entity,
            JigyoHokokuTokeiDataIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

    /**
     * 報告年を設定します。
     *
     * @param 報告年 報告年
     * @return {@link JigyoHokokuTokeiDataBuilder}
     */
    public JigyoHokokuTokeiDataBuilder set報告年(FlexibleYear 報告年) {
        requireNonNull(報告年, UrSystemErrorMessages.値がnull.getReplacedMessage("報告年"));
        entity.setHokokuYSeireki(報告年);
        return this;
    }

    /**
     * 報告月を設定します。
     *
     * @param 報告月 報告月
     * @return {@link JigyoHokokuTokeiDataBuilder}
     */
    public JigyoHokokuTokeiDataBuilder set報告月(RString 報告月) {
        requireNonNull(報告月, UrSystemErrorMessages.値がnull.getReplacedMessage("報告月"));
        entity.setHokokuM(報告月);
        return this;
    }

    /**
     * 集計対象年を設定します。
     *
     * @param 集計対象年 集計対象年
     * @return {@link JigyoHokokuTokeiDataBuilder}
     */
    public JigyoHokokuTokeiDataBuilder set集計対象年(FlexibleYear 集計対象年) {
        requireNonNull(集計対象年, UrSystemErrorMessages.値がnull.getReplacedMessage("集計対象年"));
        entity.setShukeiTaishoYSeireki(集計対象年);
        return this;
    }

    /**
     * 集計対象月を設定します。
     *
     * @param 集計対象月 集計対象月
     * @return {@link JigyoHokokuTokeiDataBuilder}
     */
    public JigyoHokokuTokeiDataBuilder set集計対象月(RString 集計対象月) {
        requireNonNull(集計対象月, UrSystemErrorMessages.値がnull.getReplacedMessage("集計対象月"));
        entity.setShukeiTaishoM(集計対象月);
        return this;
    }

    /**
     * 統計対象区分を設定します。
     *
     * @param 統計対象区分 統計対象区分
     * @return {@link JigyoHokokuTokeiDataBuilder}
     */
    public JigyoHokokuTokeiDataBuilder set統計対象区分(RString 統計対象区分) {
        requireNonNull(統計対象区分, UrSystemErrorMessages.値がnull.getReplacedMessage("統計対象区分"));
        entity.setToukeiTaishoKubun(統計対象区分);
        return this;
    }

    /**
     * 市町村コードを設定します。
     *
     * @param 市町村コード 市町村コード
     * @return {@link JigyoHokokuTokeiDataBuilder}
     */
    public JigyoHokokuTokeiDataBuilder set市町村コード(LasdecCode 市町村コード) {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        entity.setShichosonCode(市町村コード);
        return this;
    }

    /**
     * 表番号を設定します。
     *
     * @param 表番号 表番号
     * @return {@link JigyoHokokuTokeiDataBuilder}
     */
    public JigyoHokokuTokeiDataBuilder set表番号(Code 表番号) {
        requireNonNull(表番号, UrSystemErrorMessages.値がnull.getReplacedMessage("表番号"));
        entity.setHyoNo(表番号);
        return this;
    }

    /**
     * 集計番号を設定します。
     *
     * @param 集計番号 集計番号
     * @return {@link JigyoHokokuTokeiDataBuilder}
     */
    public JigyoHokokuTokeiDataBuilder set集計番号(Code 集計番号) {
        requireNonNull(集計番号, UrSystemErrorMessages.値がnull.getReplacedMessage("集計番号"));
        entity.setShukeiNo(集計番号);
        return this;
    }

    /**
     * 集計単位を設定します。
     *
     * @param 集計単位 集計単位
     * @return {@link JigyoHokokuTokeiDataBuilder}
     */
    public JigyoHokokuTokeiDataBuilder set集計単位(Code 集計単位) {
        requireNonNull(集計単位, UrSystemErrorMessages.値がnull.getReplacedMessage("集計単位"));
        entity.setShukeiTani(集計単位);
        return this;
    }

    /**
     * 縦番号を設定します。
     *
     * @param 縦番号 縦番号
     * @return {@link JigyoHokokuTokeiDataBuilder}
     */
    public JigyoHokokuTokeiDataBuilder set縦番号(Decimal 縦番号) {
        requireNonNull(縦番号, UrSystemErrorMessages.値がnull.getReplacedMessage("縦番号"));
        entity.setTateNo(縦番号);
        return this;
    }

    /**
     * 横番号を設定します。
     *
     * @param 横番号 横番号
     * @return {@link JigyoHokokuTokeiDataBuilder}
     */
    public JigyoHokokuTokeiDataBuilder set横番号(Decimal 横番号) {
        requireNonNull(横番号, UrSystemErrorMessages.値がnull.getReplacedMessage("横番号"));
        entity.setYokoNo(横番号);
        return this;
    }

    /**
     * 集計結果値を設定します。
     *
     * @param 集計結果値 集計結果値
     * @return {@link JigyoHokokuTokeiDataBuilder}
     */
    public JigyoHokokuTokeiDataBuilder set集計結果値(Decimal 集計結果値) {
        entity.setShukeiKekkaAtai(集計結果値);
        return this;
    }

    /**
     * 集計項目名称を設定します。
     *
     * @param 集計項目名称 集計項目名称
     * @return {@link JigyoHokokuTokeiDataBuilder}
     */
    public JigyoHokokuTokeiDataBuilder set集計項目名称(RString 集計項目名称) {
        entity.setShukeiKomokuMeisho(集計項目名称);
        return this;
    }

    /**
     * 縦項目コードを設定します。
     *
     * @param 縦項目コード 縦項目コード
     * @return {@link JigyoHokokuTokeiDataBuilder}
     */
    public JigyoHokokuTokeiDataBuilder set縦項目コード(Code 縦項目コード) {
        entity.setTateKomokuCode(縦項目コード);
        return this;
    }

    /**
     * 横項目コードを設定します。
     *
     * @param 横項目コード 横項目コード
     * @return {@link JigyoHokokuTokeiDataBuilder}
     */
    public JigyoHokokuTokeiDataBuilder set横項目コード(Code 横項目コード) {
        entity.setYokoKomokuCode(横項目コード);
        return this;
    }

    /**
     * {@link JigyoHokokuTokeiData}のインスタンスを生成します。
     *
     * @return {@link JigyoHokokuTokeiData}のインスタンス
     */
    public JigyoHokokuTokeiData build() {
        return new JigyoHokokuTokeiData(entity, id);
    }
}
