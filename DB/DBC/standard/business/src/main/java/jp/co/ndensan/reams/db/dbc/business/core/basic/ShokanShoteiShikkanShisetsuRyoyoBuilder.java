/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3052ShokanShoteiShikkanShisetsuRyoyoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link ShokanShoteiShikkanShisetsuRyoyo}の編集を行うビルダークラスです。
 */
public class ShokanShoteiShikkanShisetsuRyoyoBuilder {

    private final DbT3052ShokanShoteiShikkanShisetsuRyoyoEntity entity;
    private final ShokanShoteiShikkanShisetsuRyoyoIdentifier id;

    /**
     * {@link DbT3052ShokanShoteiShikkanShisetsuRyoyoEntity}より{@link ShokanShoteiShikkanShisetsuRyoyo}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT3052ShokanShoteiShikkanShisetsuRyoyoEntity}
     * @param id {@link ShokanShoteiShikkanShisetsuRyoyoIdentifier}
     *
     */
    ShokanShoteiShikkanShisetsuRyoyoBuilder(
            DbT3052ShokanShoteiShikkanShisetsuRyoyoEntity entity,
            ShokanShoteiShikkanShisetsuRyoyoIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

//TODO Key項目のsetterメソッドは削除してください。
//TODO 一緒に置換される値のまとまりで不変なクラスを作成し、その単位でsetterを作る様に見直してください。
    /**
     * 被保険者番号を設定します。
     *
     * @param 被保険者番号 被保険者番号
     * @return {@link ShokanShoteiShikkanShisetsuRyoyoBuilder}
     */
    public ShokanShoteiShikkanShisetsuRyoyoBuilder set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHiHokenshaNo(被保険者番号);
        return this;
    }

    /**
     * サービス提供年月を設定します。
     *
     * @param サービス提供年月 サービス提供年月
     * @return {@link ShokanShoteiShikkanShisetsuRyoyoBuilder}
     */
    public ShokanShoteiShikkanShisetsuRyoyoBuilder setサービス提供年月(FlexibleYearMonth サービス提供年月) {
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        entity.setServiceTeikyoYM(サービス提供年月);
        return this;
    }

    /**
     * 整理番号を設定します。
     *
     * @param 整理番号 整理番号
     * @return {@link ShokanShoteiShikkanShisetsuRyoyoBuilder}
     */
    public ShokanShoteiShikkanShisetsuRyoyoBuilder set整理番号(RString 整理番号) {
        requireNonNull(整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("整理番号"));
        entity.setSeiriNo(整理番号);
        return this;
    }

    /**
     * 事業者番号を設定します。
     *
     * @param 事業者番号 事業者番号
     * @return {@link ShokanShoteiShikkanShisetsuRyoyoBuilder}
     */
    public ShokanShoteiShikkanShisetsuRyoyoBuilder set事業者番号(JigyoshaNo 事業者番号) {
        requireNonNull(事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者番号"));
        entity.setJigyoshaNo(事業者番号);
        return this;
    }

    /**
     * 様式番号を設定します。
     *
     * @param 様式番号 様式番号
     * @return {@link ShokanShoteiShikkanShisetsuRyoyoBuilder}
     */
    public ShokanShoteiShikkanShisetsuRyoyoBuilder set様式番号(RString 様式番号) {
        requireNonNull(様式番号, UrSystemErrorMessages.値がnull.getReplacedMessage("様式番号"));
        entity.setYoshikiNo(様式番号);
        return this;
    }

    /**
     * 明細番号を設定します。
     *
     * @param 明細番号 明細番号
     * @return {@link ShokanShoteiShikkanShisetsuRyoyoBuilder}
     */
    public ShokanShoteiShikkanShisetsuRyoyoBuilder set明細番号(RString 明細番号) {
        requireNonNull(明細番号, UrSystemErrorMessages.値がnull.getReplacedMessage("明細番号"));
        entity.setMeisaiNo(明細番号);
        return this;
    }

    /**
     * 連番を設定します。
     *
     * @param 連番 連番
     * @return {@link ShokanShoteiShikkanShisetsuRyoyoBuilder}
     */
    public ShokanShoteiShikkanShisetsuRyoyoBuilder set連番(RString 連番) {
        requireNonNull(連番, UrSystemErrorMessages.値がnull.getReplacedMessage("連番"));
        entity.setRenban(連番);
        return this;
    }

    /**
     * 緊急時傷病名１を設定します。
     *
     * @param 緊急時傷病名１ 緊急時傷病名１
     * @return {@link ShokanShoteiShikkanShisetsuRyoyoBuilder}
     */
    public ShokanShoteiShikkanShisetsuRyoyoBuilder set緊急時傷病名１(RString 緊急時傷病名１) {
        entity.setKinkyuShobyoName1(緊急時傷病名１);
        return this;
    }

    /**
     * 緊急時傷病名２を設定します。
     *
     * @param 緊急時傷病名２ 緊急時傷病名２
     * @return {@link ShokanShoteiShikkanShisetsuRyoyoBuilder}
     */
    public ShokanShoteiShikkanShisetsuRyoyoBuilder set緊急時傷病名２(RString 緊急時傷病名２) {
        entity.setKinkyuShobyoName2(緊急時傷病名２);
        return this;
    }

    /**
     * 緊急時傷病名３を設定します。
     *
     * @param 緊急時傷病名３ 緊急時傷病名３
     * @return {@link ShokanShoteiShikkanShisetsuRyoyoBuilder}
     */
    public ShokanShoteiShikkanShisetsuRyoyoBuilder set緊急時傷病名３(RString 緊急時傷病名３) {
        entity.setKinkyuShobyoName3(緊急時傷病名３);
        return this;
    }

    /**
     * 緊急時治療開始年月日１を設定します。
     *
     * @param 緊急時治療開始年月日１ 緊急時治療開始年月日１
     * @return {@link ShokanShoteiShikkanShisetsuRyoyoBuilder}
     */
    public ShokanShoteiShikkanShisetsuRyoyoBuilder set緊急時治療開始年月日１(FlexibleDate 緊急時治療開始年月日１) {
        entity.setKinkyuChiryoKaishiYMD1(緊急時治療開始年月日１);
        return this;
    }

    /**
     * 緊急時治療開始年月日２を設定します。
     *
     * @param 緊急時治療開始年月日２ 緊急時治療開始年月日２
     * @return {@link ShokanShoteiShikkanShisetsuRyoyoBuilder}
     */
    public ShokanShoteiShikkanShisetsuRyoyoBuilder set緊急時治療開始年月日２(FlexibleDate 緊急時治療開始年月日２) {
        entity.setKinkyuChiryoKaishiYMD2(緊急時治療開始年月日２);
        return this;
    }

    /**
     * 緊急時治療開始年月日３を設定します。
     *
     * @param 緊急時治療開始年月日３ 緊急時治療開始年月日３
     * @return {@link ShokanShoteiShikkanShisetsuRyoyoBuilder}
     */
    public ShokanShoteiShikkanShisetsuRyoyoBuilder set緊急時治療開始年月日３(FlexibleDate 緊急時治療開始年月日３) {
        entity.setKinkyuChiryoKaishiYMD3(緊急時治療開始年月日３);
        return this;
    }

    /**
     * 往診日数を設定します。
     *
     * @param 往診日数 往診日数
     * @return {@link ShokanShoteiShikkanShisetsuRyoyoBuilder}
     */
    public ShokanShoteiShikkanShisetsuRyoyoBuilder set往診日数(int 往診日数) {
        requireNonNull(往診日数, UrSystemErrorMessages.値がnull.getReplacedMessage("往診日数"));
        entity.setOshinNissu(往診日数);
        return this;
    }

    /**
     * 往診医療機関名を設定します。
     *
     * @param 往診医療機関名 往診医療機関名
     * @return {@link ShokanShoteiShikkanShisetsuRyoyoBuilder}
     */
    public ShokanShoteiShikkanShisetsuRyoyoBuilder set往診医療機関名(RString 往診医療機関名) {
        entity.setOshinIryoKikanName(往診医療機関名);
        return this;
    }

    /**
     * 通院日数を設定します。
     *
     * @param 通院日数 通院日数
     * @return {@link ShokanShoteiShikkanShisetsuRyoyoBuilder}
     */
    public ShokanShoteiShikkanShisetsuRyoyoBuilder set通院日数(int 通院日数) {
        requireNonNull(通院日数, UrSystemErrorMessages.値がnull.getReplacedMessage("通院日数"));
        entity.setTsuinNissu(通院日数);
        return this;
    }

    /**
     * 通院医療機関名を設定します。
     *
     * @param 通院医療機関名 通院医療機関名
     * @return {@link ShokanShoteiShikkanShisetsuRyoyoBuilder}
     */
    public ShokanShoteiShikkanShisetsuRyoyoBuilder set通院医療機関名(RString 通院医療機関名) {
        entity.setTsuinKikanName(通院医療機関名);
        return this;
    }

    /**
     * 緊急時治療管理単位数を設定します。
     *
     * @param 緊急時治療管理単位数 緊急時治療管理単位数
     * @return {@link ShokanShoteiShikkanShisetsuRyoyoBuilder}
     */
    public ShokanShoteiShikkanShisetsuRyoyoBuilder set緊急時治療管理単位数(int 緊急時治療管理単位数) {
        requireNonNull(緊急時治療管理単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("緊急時治療管理単位数"));
        entity.setKinkyuChiryoKanriTanisu(緊急時治療管理単位数);
        return this;
    }

    /**
     * 緊急時治療管理日数を設定します。
     *
     * @param 緊急時治療管理日数 緊急時治療管理日数
     * @return {@link ShokanShoteiShikkanShisetsuRyoyoBuilder}
     */
    public ShokanShoteiShikkanShisetsuRyoyoBuilder set緊急時治療管理日数(int 緊急時治療管理日数) {
        requireNonNull(緊急時治療管理日数, UrSystemErrorMessages.値がnull.getReplacedMessage("緊急時治療管理日数"));
        entity.setKinkyuChiryoKanriNissu(緊急時治療管理日数);
        return this;
    }

    /**
     * 緊急時治療管理小計を設定します。
     *
     * @param 緊急時治療管理小計 緊急時治療管理小計
     * @return {@link ShokanShoteiShikkanShisetsuRyoyoBuilder}
     */
    public ShokanShoteiShikkanShisetsuRyoyoBuilder set緊急時治療管理小計(int 緊急時治療管理小計) {
        requireNonNull(緊急時治療管理小計, UrSystemErrorMessages.値がnull.getReplacedMessage("緊急時治療管理小計"));
        entity.setKinkyuChiryoKanriSubTotal(緊急時治療管理小計);
        return this;
    }

    /**
     * リハビリテーション単位数を設定します。
     *
     * @param リハビリテーション単位数 リハビリテーション単位数
     * @return {@link ShokanShoteiShikkanShisetsuRyoyoBuilder}
     */
    public ShokanShoteiShikkanShisetsuRyoyoBuilder setリハビリテーション単位数(int リハビリテーション単位数) {
        requireNonNull(リハビリテーション単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("リハビリテーション単位数"));
        entity.setRehabilitationTanisu(リハビリテーション単位数);
        return this;
    }

    /**
     * 処置単位数を設定します。
     *
     * @param 処置単位数 処置単位数
     * @return {@link ShokanShoteiShikkanShisetsuRyoyoBuilder}
     */
    public ShokanShoteiShikkanShisetsuRyoyoBuilder set処置単位数(int 処置単位数) {
        requireNonNull(処置単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("処置単位数"));
        entity.setShochiTanisu(処置単位数);
        return this;
    }

    /**
     * 手術単位数を設定します。
     *
     * @param 手術単位数 手術単位数
     * @return {@link ShokanShoteiShikkanShisetsuRyoyoBuilder}
     */
    public ShokanShoteiShikkanShisetsuRyoyoBuilder set手術単位数(int 手術単位数) {
        requireNonNull(手術単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("手術単位数"));
        entity.setShujutsuTanisu(手術単位数);
        return this;
    }

    /**
     * 麻酔単位数を設定します。
     *
     * @param 麻酔単位数 麻酔単位数
     * @return {@link ShokanShoteiShikkanShisetsuRyoyoBuilder}
     */
    public ShokanShoteiShikkanShisetsuRyoyoBuilder set麻酔単位数(int 麻酔単位数) {
        requireNonNull(麻酔単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("麻酔単位数"));
        entity.setMasuiTanisu(麻酔単位数);
        return this;
    }

    /**
     * 放射線治療単位数を設定します。
     *
     * @param 放射線治療単位数 放射線治療単位数
     * @return {@link ShokanShoteiShikkanShisetsuRyoyoBuilder}
     */
    public ShokanShoteiShikkanShisetsuRyoyoBuilder set放射線治療単位数(int 放射線治療単位数) {
        requireNonNull(放射線治療単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("放射線治療単位数"));
        entity.setHoshasenChiryoTanisu(放射線治療単位数);
        return this;
    }

    /**
     * 摘要１を設定します。
     *
     * @param 摘要１ 摘要１
     * @return {@link ShokanShoteiShikkanShisetsuRyoyoBuilder}
     */
    public ShokanShoteiShikkanShisetsuRyoyoBuilder set摘要１(RString 摘要１) {
        entity.setTekiyo1(摘要１);
        return this;
    }

    /**
     * 摘要２を設定します。
     *
     * @param 摘要２ 摘要２
     * @return {@link ShokanShoteiShikkanShisetsuRyoyoBuilder}
     */
    public ShokanShoteiShikkanShisetsuRyoyoBuilder set摘要２(RString 摘要２) {
        entity.setTekiyo2(摘要２);
        return this;
    }

    /**
     * 摘要３を設定します。
     *
     * @param 摘要３ 摘要３
     * @return {@link ShokanShoteiShikkanShisetsuRyoyoBuilder}
     */
    public ShokanShoteiShikkanShisetsuRyoyoBuilder set摘要３(RString 摘要３) {
        entity.setTekiyo3(摘要３);
        return this;
    }

    /**
     * 摘要４を設定します。
     *
     * @param 摘要４ 摘要４
     * @return {@link ShokanShoteiShikkanShisetsuRyoyoBuilder}
     */
    public ShokanShoteiShikkanShisetsuRyoyoBuilder set摘要４(RString 摘要４) {
        entity.setTekiyo4(摘要４);
        return this;
    }

    /**
     * 摘要５を設定します。
     *
     * @param 摘要５ 摘要５
     * @return {@link ShokanShoteiShikkanShisetsuRyoyoBuilder}
     */
    public ShokanShoteiShikkanShisetsuRyoyoBuilder set摘要５(RString 摘要５) {
        entity.setTekiyo5(摘要５);
        return this;
    }

    /**
     * 摘要６を設定します。
     *
     * @param 摘要６ 摘要６
     * @return {@link ShokanShoteiShikkanShisetsuRyoyoBuilder}
     */
    public ShokanShoteiShikkanShisetsuRyoyoBuilder set摘要６(RString 摘要６) {
        entity.setTekiyo6(摘要６);
        return this;
    }

    /**
     * 摘要７を設定します。
     *
     * @param 摘要７ 摘要７
     * @return {@link ShokanShoteiShikkanShisetsuRyoyoBuilder}
     */
    public ShokanShoteiShikkanShisetsuRyoyoBuilder set摘要７(RString 摘要７) {
        entity.setTekiyo7(摘要７);
        return this;
    }

    /**
     * 摘要８を設定します。
     *
     * @param 摘要８ 摘要８
     * @return {@link ShokanShoteiShikkanShisetsuRyoyoBuilder}
     */
    public ShokanShoteiShikkanShisetsuRyoyoBuilder set摘要８(RString 摘要８) {
        entity.setTekiyo8(摘要８);
        return this;
    }

    /**
     * 摘要９を設定します。
     *
     * @param 摘要９ 摘要９
     * @return {@link ShokanShoteiShikkanShisetsuRyoyoBuilder}
     */
    public ShokanShoteiShikkanShisetsuRyoyoBuilder set摘要９(RString 摘要９) {
        entity.setTekiyo9(摘要９);
        return this;
    }

    /**
     * 摘要１０を設定します。
     *
     * @param 摘要１０ 摘要１０
     * @return {@link ShokanShoteiShikkanShisetsuRyoyoBuilder}
     */
    public ShokanShoteiShikkanShisetsuRyoyoBuilder set摘要１０(RString 摘要１０) {
        entity.setTekiyo10(摘要１０);
        return this;
    }

    /**
     * 摘要１１を設定します。
     *
     * @param 摘要１１ 摘要１１
     * @return {@link ShokanShoteiShikkanShisetsuRyoyoBuilder}
     */
    public ShokanShoteiShikkanShisetsuRyoyoBuilder set摘要１１(RString 摘要１１) {
        entity.setTekiyo11(摘要１１);
        return this;
    }

    /**
     * 摘要１２を設定します。
     *
     * @param 摘要１２ 摘要１２
     * @return {@link ShokanShoteiShikkanShisetsuRyoyoBuilder}
     */
    public ShokanShoteiShikkanShisetsuRyoyoBuilder set摘要１２(RString 摘要１２) {
        entity.setTekiyo12(摘要１２);
        return this;
    }

    /**
     * 摘要１３を設定します。
     *
     * @param 摘要１３ 摘要１３
     * @return {@link ShokanShoteiShikkanShisetsuRyoyoBuilder}
     */
    public ShokanShoteiShikkanShisetsuRyoyoBuilder set摘要１３(RString 摘要１３) {
        entity.setTekiyo13(摘要１３);
        return this;
    }

    /**
     * 摘要１４を設定します。
     *
     * @param 摘要１４ 摘要１４
     * @return {@link ShokanShoteiShikkanShisetsuRyoyoBuilder}
     */
    public ShokanShoteiShikkanShisetsuRyoyoBuilder set摘要１４(RString 摘要１４) {
        entity.setTekiyo14(摘要１４);
        return this;
    }

    /**
     * 摘要１５を設定します。
     *
     * @param 摘要１５ 摘要１５
     * @return {@link ShokanShoteiShikkanShisetsuRyoyoBuilder}
     */
    public ShokanShoteiShikkanShisetsuRyoyoBuilder set摘要１５(RString 摘要１５) {
        entity.setTekiyo15(摘要１５);
        return this;
    }

    /**
     * 摘要１６を設定します。
     *
     * @param 摘要１６ 摘要１６
     * @return {@link ShokanShoteiShikkanShisetsuRyoyoBuilder}
     */
    public ShokanShoteiShikkanShisetsuRyoyoBuilder set摘要１６(RString 摘要１６) {
        entity.setTekiyo16(摘要１６);
        return this;
    }

    /**
     * 摘要１７を設定します。
     *
     * @param 摘要１７ 摘要１７
     * @return {@link ShokanShoteiShikkanShisetsuRyoyoBuilder}
     */
    public ShokanShoteiShikkanShisetsuRyoyoBuilder set摘要１７(RString 摘要１７) {
        entity.setTekiyo17(摘要１７);
        return this;
    }

    /**
     * 摘要１８を設定します。
     *
     * @param 摘要１８ 摘要１８
     * @return {@link ShokanShoteiShikkanShisetsuRyoyoBuilder}
     */
    public ShokanShoteiShikkanShisetsuRyoyoBuilder set摘要１８(RString 摘要１８) {
        entity.setTekiyo18(摘要１８);
        return this;
    }

    /**
     * 摘要１９を設定します。
     *
     * @param 摘要１９ 摘要１９
     * @return {@link ShokanShoteiShikkanShisetsuRyoyoBuilder}
     */
    public ShokanShoteiShikkanShisetsuRyoyoBuilder set摘要１９(RString 摘要１９) {
        entity.setTekiyo19(摘要１９);
        return this;
    }

    /**
     * 摘要２０を設定します。
     *
     * @param 摘要２０ 摘要２０
     * @return {@link ShokanShoteiShikkanShisetsuRyoyoBuilder}
     */
    public ShokanShoteiShikkanShisetsuRyoyoBuilder set摘要２０(RString 摘要２０) {
        entity.setTekiyo20(摘要２０);
        return this;
    }

    /**
     * 緊急時施設療養費合計単位数を設定します。
     *
     * @param 緊急時施設療養費合計単位数 緊急時施設療養費合計単位数
     * @return {@link ShokanShoteiShikkanShisetsuRyoyoBuilder}
     */
    public ShokanShoteiShikkanShisetsuRyoyoBuilder set緊急時施設療養費合計単位数(int 緊急時施設療養費合計単位数) {
        requireNonNull(緊急時施設療養費合計単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("緊急時施設療養費合計単位数"));
        entity.setKinkyuShisetsuRyoyohiTotalTanisu(緊急時施設療養費合計単位数);
        return this;
    }

    /**
     * 所定疾患施設療養費傷病名１を設定します。
     *
     * @param 所定疾患施設療養費傷病名１ 所定疾患施設療養費傷病名１
     * @return {@link ShokanShoteiShikkanShisetsuRyoyoBuilder}
     */
    public ShokanShoteiShikkanShisetsuRyoyoBuilder set所定疾患施設療養費傷病名１(RString 所定疾患施設療養費傷病名１) {
        entity.setShoteiShikkanShobyoName1(所定疾患施設療養費傷病名１);
        return this;
    }

    /**
     * 所定疾患施設療養費傷病名２を設定します。
     *
     * @param 所定疾患施設療養費傷病名２ 所定疾患施設療養費傷病名２
     * @return {@link ShokanShoteiShikkanShisetsuRyoyoBuilder}
     */
    public ShokanShoteiShikkanShisetsuRyoyoBuilder set所定疾患施設療養費傷病名２(RString 所定疾患施設療養費傷病名２) {
        entity.setShoteiShikkanShobyoName2(所定疾患施設療養費傷病名２);
        return this;
    }

    /**
     * 所定疾患施設療養費傷病名３を設定します。
     *
     * @param 所定疾患施設療養費傷病名３ 所定疾患施設療養費傷病名３
     * @return {@link ShokanShoteiShikkanShisetsuRyoyoBuilder}
     */
    public ShokanShoteiShikkanShisetsuRyoyoBuilder set所定疾患施設療養費傷病名３(RString 所定疾患施設療養費傷病名３) {
        entity.setShoteiShikkanShobyoName3(所定疾患施設療養費傷病名３);
        return this;
    }

    /**
     * 所定疾患施設療養費開始年月日１を設定します。
     *
     * @param 所定疾患施設療養費開始年月日１ 所定疾患施設療養費開始年月日１
     * @return {@link ShokanShoteiShikkanShisetsuRyoyoBuilder}
     */
    public ShokanShoteiShikkanShisetsuRyoyoBuilder set所定疾患施設療養費開始年月日１(FlexibleDate 所定疾患施設療養費開始年月日１) {
        entity.setShoteiShikkanShobyoKaishiYMD1(所定疾患施設療養費開始年月日１);
        return this;
    }

    /**
     * 所定疾患施設療養費開始年月日２を設定します。
     *
     * @param 所定疾患施設療養費開始年月日２ 所定疾患施設療養費開始年月日２
     * @return {@link ShokanShoteiShikkanShisetsuRyoyoBuilder}
     */
    public ShokanShoteiShikkanShisetsuRyoyoBuilder set所定疾患施設療養費開始年月日２(FlexibleDate 所定疾患施設療養費開始年月日２) {
        entity.setShoteiShikkanShobyoKaishiYMD2(所定疾患施設療養費開始年月日２);
        return this;
    }

    /**
     * 所定疾患施設療養費開始年月日３を設定します。
     *
     * @param 所定疾患施設療養費開始年月日３ 所定疾患施設療養費開始年月日３
     * @return {@link ShokanShoteiShikkanShisetsuRyoyoBuilder}
     */
    public ShokanShoteiShikkanShisetsuRyoyoBuilder set所定疾患施設療養費開始年月日３(FlexibleDate 所定疾患施設療養費開始年月日３) {
        entity.setShoteiShikkanShobyoKaishiYMD3(所定疾患施設療養費開始年月日３);
        return this;
    }

    /**
     * 所定疾患施設療養費単位数を設定します。
     *
     * @param 所定疾患施設療養費単位数 所定疾患施設療養費単位数
     * @return {@link ShokanShoteiShikkanShisetsuRyoyoBuilder}
     */
    public ShokanShoteiShikkanShisetsuRyoyoBuilder set所定疾患施設療養費単位数(int 所定疾患施設療養費単位数) {
        requireNonNull(所定疾患施設療養費単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("所定疾患施設療養費単位数"));
        entity.setShoteiShikkanTanisu(所定疾患施設療養費単位数);
        return this;
    }

    /**
     * 所定疾患施設療養費日数を設定します。
     *
     * @param 所定疾患施設療養費日数 所定疾患施設療養費日数
     * @return {@link ShokanShoteiShikkanShisetsuRyoyoBuilder}
     */
    public ShokanShoteiShikkanShisetsuRyoyoBuilder set所定疾患施設療養費日数(int 所定疾患施設療養費日数) {
        requireNonNull(所定疾患施設療養費日数, UrSystemErrorMessages.値がnull.getReplacedMessage("所定疾患施設療養費日数"));
        entity.setShoteiShikkanNissu(所定疾患施設療養費日数);
        return this;
    }

    /**
     * 所定疾患施設療養費小計を設定します。
     *
     * @param 所定疾患施設療養費小計 所定疾患施設療養費小計
     * @return {@link ShokanShoteiShikkanShisetsuRyoyoBuilder}
     */
    public ShokanShoteiShikkanShisetsuRyoyoBuilder set所定疾患施設療養費小計(int 所定疾患施設療養費小計) {
        requireNonNull(所定疾患施設療養費小計, UrSystemErrorMessages.値がnull.getReplacedMessage("所定疾患施設療養費小計"));
        entity.setShoteiShikkanSubTotal(所定疾患施設療養費小計);
        return this;
    }

    /**
     * {@link ShokanShoteiShikkanShisetsuRyoyo}のインスタンスを生成します。
     *
     * @return {@link ShokanShoteiShikkanShisetsuRyoyo}のインスタンス
     */
    public ShokanShoteiShikkanShisetsuRyoyo build() {
        return new ShokanShoteiShikkanShisetsuRyoyo(entity, id);
    }
}
