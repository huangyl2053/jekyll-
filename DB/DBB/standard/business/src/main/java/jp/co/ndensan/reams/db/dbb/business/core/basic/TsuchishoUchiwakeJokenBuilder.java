/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2014TsuchishoUchiwakeJokenEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link TsuchishoUchiwakeJoken}の編集を行うビルダークラスです。
 */
public class TsuchishoUchiwakeJokenBuilder {

    private final DbT2014TsuchishoUchiwakeJokenEntity entity;
    private final TsuchishoUchiwakeJokenIdentifier id;

    /**
     * {@link DbT2014TsuchishoUchiwakeJokenEntity}より{@link TsuchishoUchiwakeJoken}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT2014TsuchishoUchiwakeJokenEntity}
     * @param id {@link TsuchishoUchiwakeJokenIdentifier}
     *
     */
    TsuchishoUchiwakeJokenBuilder(
            DbT2014TsuchishoUchiwakeJokenEntity entity,
            TsuchishoUchiwakeJokenIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

//TODO Key項目のsetterメソッドは削除してください。
//TODO 一緒に置換される値のまとまりで不変なクラスを作成し、その単位でsetterを作る様に見直してください。
    /**
     * 打ち分け条件を設定します。
     *
     * @param 打ち分け条件 打ち分け条件
     * @return {@link TsuchishoUchiwakeJokenBuilder}
     */
    public TsuchishoUchiwakeJokenBuilder set打ち分け条件(RString 打ち分け条件) {
        requireNonNull(打ち分け条件, UrSystemErrorMessages.値がnull.getReplacedMessage("打ち分け条件"));
        entity.setUchiwakeJoken(打ち分け条件);
        return this;
    }

    /**
     * 保存日時を設定します。
     *
     * @param 保存日時 保存日時
     * @return {@link TsuchishoUchiwakeJokenBuilder}
     */
    public TsuchishoUchiwakeJokenBuilder set保存日時(RDateTime 保存日時) {
        requireNonNull(保存日時, UrSystemErrorMessages.値がnull.getReplacedMessage("保存日時"));
        entity.setHozonDateTime(保存日時);
        return this;
    }

    /**
     * 賦課処理区分を設定します。
     *
     * @param 賦課処理区分 賦課処理区分
     * @return {@link TsuchishoUchiwakeJokenBuilder}
     */
    public TsuchishoUchiwakeJokenBuilder set賦課処理区分(RString 賦課処理区分) {
        requireNonNull(賦課処理区分, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課処理区分"));
        entity.setFukaShoriKubun(賦課処理区分);
        return this;
    }

    /**
     * 選択通知書01を設定します。
     *
     * @param 選択通知書01 選択通知書01
     * @return {@link TsuchishoUchiwakeJokenBuilder}
     */
    public TsuchishoUchiwakeJokenBuilder set選択通知書01(RString 選択通知書01) {
        requireNonNull(選択通知書01, UrSystemErrorMessages.値がnull.getReplacedMessage("選択通知書01"));
        entity.setSelectTsuchisho01(選択通知書01);
        return this;
    }

    /**
     * 選択現金口座01を設定します。
     *
     * @param 選択現金口座01 選択現金口座01
     * @return {@link TsuchishoUchiwakeJokenBuilder}
     */
    public TsuchishoUchiwakeJokenBuilder set選択現金口座01(RString 選択現金口座01) {
        requireNonNull(選択現金口座01, UrSystemErrorMessages.値がnull.getReplacedMessage("選択現金口座01"));
        entity.setSelectGenkinKoza01(選択現金口座01);
        return this;
    }

    /**
     * 出力順グループ名01を設定します。
     *
     * @param 出力順グループ名01 出力順グループ名01
     * @return {@link TsuchishoUchiwakeJokenBuilder}
     */
    public TsuchishoUchiwakeJokenBuilder set出力順グループ名01(RString 出力順グループ名01) {
        requireNonNull(出力順グループ名01, UrSystemErrorMessages.値がnull.getReplacedMessage("出力順グループ名01"));
        entity.setSortGroupName01(出力順グループ名01);
        return this;
    }

    /**
     * 選択通知書02を設定します。
     *
     * @param 選択通知書02 選択通知書02
     * @return {@link TsuchishoUchiwakeJokenBuilder}
     */
    public TsuchishoUchiwakeJokenBuilder set選択通知書02(RString 選択通知書02) {
        requireNonNull(選択通知書02, UrSystemErrorMessages.値がnull.getReplacedMessage("選択通知書02"));
        entity.setSelectTsuchisho02(選択通知書02);
        return this;
    }

    /**
     * 選択現金口座02を設定します。
     *
     * @param 選択現金口座02 選択現金口座02
     * @return {@link TsuchishoUchiwakeJokenBuilder}
     */
    public TsuchishoUchiwakeJokenBuilder set選択現金口座02(RString 選択現金口座02) {
        requireNonNull(選択現金口座02, UrSystemErrorMessages.値がnull.getReplacedMessage("選択現金口座02"));
        entity.setSelectGenkinKoza02(選択現金口座02);
        return this;
    }

    /**
     * 出力順グループ名02を設定します。
     *
     * @param 出力順グループ名02 出力順グループ名02
     * @return {@link TsuchishoUchiwakeJokenBuilder}
     */
    public TsuchishoUchiwakeJokenBuilder set出力順グループ名02(RString 出力順グループ名02) {
        requireNonNull(出力順グループ名02, UrSystemErrorMessages.値がnull.getReplacedMessage("出力順グループ名02"));
        entity.setSortGroupName02(出力順グループ名02);
        return this;
    }

    /**
     * 選択通知書03を設定します。
     *
     * @param 選択通知書03 選択通知書03
     * @return {@link TsuchishoUchiwakeJokenBuilder}
     */
    public TsuchishoUchiwakeJokenBuilder set選択通知書03(RString 選択通知書03) {
        requireNonNull(選択通知書03, UrSystemErrorMessages.値がnull.getReplacedMessage("選択通知書03"));
        entity.setSelectTsuchisho03(選択通知書03);
        return this;
    }

    /**
     * 選択現金口座03を設定します。
     *
     * @param 選択現金口座03 選択現金口座03
     * @return {@link TsuchishoUchiwakeJokenBuilder}
     */
    public TsuchishoUchiwakeJokenBuilder set選択現金口座03(RString 選択現金口座03) {
        requireNonNull(選択現金口座03, UrSystemErrorMessages.値がnull.getReplacedMessage("選択現金口座03"));
        entity.setSelectGenkinKoza03(選択現金口座03);
        return this;
    }

    /**
     * 出力順グループ名03を設定します。
     *
     * @param 出力順グループ名03 出力順グループ名03
     * @return {@link TsuchishoUchiwakeJokenBuilder}
     */
    public TsuchishoUchiwakeJokenBuilder set出力順グループ名03(RString 出力順グループ名03) {
        requireNonNull(出力順グループ名03, UrSystemErrorMessages.値がnull.getReplacedMessage("出力順グループ名03"));
        entity.setSortGroupName03(出力順グループ名03);
        return this;
    }

    /**
     * 選択通知書04を設定します。
     *
     * @param 選択通知書04 選択通知書04
     * @return {@link TsuchishoUchiwakeJokenBuilder}
     */
    public TsuchishoUchiwakeJokenBuilder set選択通知書04(RString 選択通知書04) {
        requireNonNull(選択通知書04, UrSystemErrorMessages.値がnull.getReplacedMessage("選択通知書04"));
        entity.setSelectTsuchisho04(選択通知書04);
        return this;
    }

    /**
     * 選択現金口座04を設定します。
     *
     * @param 選択現金口座04 選択現金口座04
     * @return {@link TsuchishoUchiwakeJokenBuilder}
     */
    public TsuchishoUchiwakeJokenBuilder set選択現金口座04(RString 選択現金口座04) {
        requireNonNull(選択現金口座04, UrSystemErrorMessages.値がnull.getReplacedMessage("選択現金口座04"));
        entity.setSelectGenkinKoza04(選択現金口座04);
        return this;
    }

    /**
     * 出力順グループ名04を設定します。
     *
     * @param 出力順グループ名04 出力順グループ名04
     * @return {@link TsuchishoUchiwakeJokenBuilder}
     */
    public TsuchishoUchiwakeJokenBuilder set出力順グループ名04(RString 出力順グループ名04) {
        requireNonNull(出力順グループ名04, UrSystemErrorMessages.値がnull.getReplacedMessage("出力順グループ名04"));
        entity.setSortGroupName04(出力順グループ名04);
        return this;
    }

    /**
     * 選択通知書05を設定します。
     *
     * @param 選択通知書05 選択通知書05
     * @return {@link TsuchishoUchiwakeJokenBuilder}
     */
    public TsuchishoUchiwakeJokenBuilder set選択通知書05(RString 選択通知書05) {
        requireNonNull(選択通知書05, UrSystemErrorMessages.値がnull.getReplacedMessage("選択通知書05"));
        entity.setSelectTsuchisho05(選択通知書05);
        return this;
    }

    /**
     * 選択現金口座05を設定します。
     *
     * @param 選択現金口座05 選択現金口座05
     * @return {@link TsuchishoUchiwakeJokenBuilder}
     */
    public TsuchishoUchiwakeJokenBuilder set選択現金口座05(RString 選択現金口座05) {
        requireNonNull(選択現金口座05, UrSystemErrorMessages.値がnull.getReplacedMessage("選択現金口座05"));
        entity.setSelectGenkinKoza05(選択現金口座05);
        return this;
    }

    /**
     * 出力順グループ名05を設定します。
     *
     * @param 出力順グループ名05 出力順グループ名05
     * @return {@link TsuchishoUchiwakeJokenBuilder}
     */
    public TsuchishoUchiwakeJokenBuilder set出力順グループ名05(RString 出力順グループ名05) {
        requireNonNull(出力順グループ名05, UrSystemErrorMessages.値がnull.getReplacedMessage("出力順グループ名05"));
        entity.setSortGroupName05(出力順グループ名05);
        return this;
    }

    /**
     * 選択通知書06を設定します。
     *
     * @param 選択通知書06 選択通知書06
     * @return {@link TsuchishoUchiwakeJokenBuilder}
     */
    public TsuchishoUchiwakeJokenBuilder set選択通知書06(RString 選択通知書06) {
        requireNonNull(選択通知書06, UrSystemErrorMessages.値がnull.getReplacedMessage("選択通知書06"));
        entity.setSelectTsuchisho06(選択通知書06);
        return this;
    }

    /**
     * 選択現金口座06を設定します。
     *
     * @param 選択現金口座06 選択現金口座06
     * @return {@link TsuchishoUchiwakeJokenBuilder}
     */
    public TsuchishoUchiwakeJokenBuilder set選択現金口座06(RString 選択現金口座06) {
        requireNonNull(選択現金口座06, UrSystemErrorMessages.値がnull.getReplacedMessage("選択現金口座06"));
        entity.setSelectGenkinKoza06(選択現金口座06);
        return this;
    }

    /**
     * 出力順グループ名06を設定します。
     *
     * @param 出力順グループ名06 出力順グループ名06
     * @return {@link TsuchishoUchiwakeJokenBuilder}
     */
    public TsuchishoUchiwakeJokenBuilder set出力順グループ名06(RString 出力順グループ名06) {
        requireNonNull(出力順グループ名06, UrSystemErrorMessages.値がnull.getReplacedMessage("出力順グループ名06"));
        entity.setSortGroupName06(出力順グループ名06);
        return this;
    }

    /**
     * 選択通知書07を設定します。
     *
     * @param 選択通知書07 選択通知書07
     * @return {@link TsuchishoUchiwakeJokenBuilder}
     */
    public TsuchishoUchiwakeJokenBuilder set選択通知書07(RString 選択通知書07) {
        requireNonNull(選択通知書07, UrSystemErrorMessages.値がnull.getReplacedMessage("選択通知書07"));
        entity.setSelectTsuchisho07(選択通知書07);
        return this;
    }

    /**
     * 選択現金口座07を設定します。
     *
     * @param 選択現金口座07 選択現金口座07
     * @return {@link TsuchishoUchiwakeJokenBuilder}
     */
    public TsuchishoUchiwakeJokenBuilder set選択現金口座07(RString 選択現金口座07) {
        requireNonNull(選択現金口座07, UrSystemErrorMessages.値がnull.getReplacedMessage("選択現金口座07"));
        entity.setSelectGenkinKoza07(選択現金口座07);
        return this;
    }

    /**
     * 出力順グループ名07を設定します。
     *
     * @param 出力順グループ名07 出力順グループ名07
     * @return {@link TsuchishoUchiwakeJokenBuilder}
     */
    public TsuchishoUchiwakeJokenBuilder set出力順グループ名07(RString 出力順グループ名07) {
        requireNonNull(出力順グループ名07, UrSystemErrorMessages.値がnull.getReplacedMessage("出力順グループ名07"));
        entity.setSortGroupName07(出力順グループ名07);
        return this;
    }

    /**
     * 選択通知書08を設定します。
     *
     * @param 選択通知書08 選択通知書08
     * @return {@link TsuchishoUchiwakeJokenBuilder}
     */
    public TsuchishoUchiwakeJokenBuilder set選択通知書08(RString 選択通知書08) {
        requireNonNull(選択通知書08, UrSystemErrorMessages.値がnull.getReplacedMessage("選択通知書08"));
        entity.setSelectTsuchisho08(選択通知書08);
        return this;
    }

    /**
     * 選択現金口座08を設定します。
     *
     * @param 選択現金口座08 選択現金口座08
     * @return {@link TsuchishoUchiwakeJokenBuilder}
     */
    public TsuchishoUchiwakeJokenBuilder set選択現金口座08(RString 選択現金口座08) {
        requireNonNull(選択現金口座08, UrSystemErrorMessages.値がnull.getReplacedMessage("選択現金口座08"));
        entity.setSelectGenkinKoza08(選択現金口座08);
        return this;
    }

    /**
     * 出力順グループ名08を設定します。
     *
     * @param 出力順グループ名08 出力順グループ名08
     * @return {@link TsuchishoUchiwakeJokenBuilder}
     */
    public TsuchishoUchiwakeJokenBuilder set出力順グループ名08(RString 出力順グループ名08) {
        requireNonNull(出力順グループ名08, UrSystemErrorMessages.値がnull.getReplacedMessage("出力順グループ名08"));
        entity.setSortGroupName08(出力順グループ名08);
        return this;
    }

    /**
     * 選択通知書09を設定します。
     *
     * @param 選択通知書09 選択通知書09
     * @return {@link TsuchishoUchiwakeJokenBuilder}
     */
    public TsuchishoUchiwakeJokenBuilder set選択通知書09(RString 選択通知書09) {
        requireNonNull(選択通知書09, UrSystemErrorMessages.値がnull.getReplacedMessage("選択通知書09"));
        entity.setSelectTsuchisho09(選択通知書09);
        return this;
    }

    /**
     * 選択現金口座09を設定します。
     *
     * @param 選択現金口座09 選択現金口座09
     * @return {@link TsuchishoUchiwakeJokenBuilder}
     */
    public TsuchishoUchiwakeJokenBuilder set選択現金口座09(RString 選択現金口座09) {
        requireNonNull(選択現金口座09, UrSystemErrorMessages.値がnull.getReplacedMessage("選択現金口座09"));
        entity.setSelectGenkinKoza09(選択現金口座09);
        return this;
    }

    /**
     * 出力順グループ名09を設定します。
     *
     * @param 出力順グループ名09 出力順グループ名09
     * @return {@link TsuchishoUchiwakeJokenBuilder}
     */
    public TsuchishoUchiwakeJokenBuilder set出力順グループ名09(RString 出力順グループ名09) {
        requireNonNull(出力順グループ名09, UrSystemErrorMessages.値がnull.getReplacedMessage("出力順グループ名09"));
        entity.setSortGroupName09(出力順グループ名09);
        return this;
    }

    /**
     * 選択通知書10を設定します。
     *
     * @param 選択通知書10 選択通知書10
     * @return {@link TsuchishoUchiwakeJokenBuilder}
     */
    public TsuchishoUchiwakeJokenBuilder set選択通知書10(RString 選択通知書10) {
        requireNonNull(選択通知書10, UrSystemErrorMessages.値がnull.getReplacedMessage("選択通知書10"));
        entity.setSelectTsuchisho10(選択通知書10);
        return this;
    }

    /**
     * 選択現金口座10を設定します。
     *
     * @param 選択現金口座10 選択現金口座10
     * @return {@link TsuchishoUchiwakeJokenBuilder}
     */
    public TsuchishoUchiwakeJokenBuilder set選択現金口座10(RString 選択現金口座10) {
        requireNonNull(選択現金口座10, UrSystemErrorMessages.値がnull.getReplacedMessage("選択現金口座10"));
        entity.setSelectGenkinKoza10(選択現金口座10);
        return this;
    }

    /**
     * 出力順グループ名10を設定します。
     *
     * @param 出力順グループ名10 出力順グループ名10
     * @return {@link TsuchishoUchiwakeJokenBuilder}
     */
    public TsuchishoUchiwakeJokenBuilder set出力順グループ名10(RString 出力順グループ名10) {
        requireNonNull(出力順グループ名10, UrSystemErrorMessages.値がnull.getReplacedMessage("出力順グループ名10"));
        entity.setSortGroupName10(出力順グループ名10);
        return this;
    }

    /**
     * 選択通知書11を設定します。
     *
     * @param 選択通知書11 選択通知書11
     * @return {@link TsuchishoUchiwakeJokenBuilder}
     */
    public TsuchishoUchiwakeJokenBuilder set選択通知書11(RString 選択通知書11) {
        requireNonNull(選択通知書11, UrSystemErrorMessages.値がnull.getReplacedMessage("選択通知書11"));
        entity.setSelectTsuchisho11(選択通知書11);
        return this;
    }

    /**
     * 選択現金口座11を設定します。
     *
     * @param 選択現金口座11 選択現金口座11
     * @return {@link TsuchishoUchiwakeJokenBuilder}
     */
    public TsuchishoUchiwakeJokenBuilder set選択現金口座11(RString 選択現金口座11) {
        requireNonNull(選択現金口座11, UrSystemErrorMessages.値がnull.getReplacedMessage("選択現金口座11"));
        entity.setSelectGenkinKoza11(選択現金口座11);
        return this;
    }

    /**
     * 出力順グループ名11を設定します。
     *
     * @param 出力順グループ名11 出力順グループ名11
     * @return {@link TsuchishoUchiwakeJokenBuilder}
     */
    public TsuchishoUchiwakeJokenBuilder set出力順グループ名11(RString 出力順グループ名11) {
        requireNonNull(出力順グループ名11, UrSystemErrorMessages.値がnull.getReplacedMessage("出力順グループ名11"));
        entity.setSortGroupName11(出力順グループ名11);
        return this;
    }

    /**
     * 選択通知書12を設定します。
     *
     * @param 選択通知書12 選択通知書12
     * @return {@link TsuchishoUchiwakeJokenBuilder}
     */
    public TsuchishoUchiwakeJokenBuilder set選択通知書12(RString 選択通知書12) {
        requireNonNull(選択通知書12, UrSystemErrorMessages.値がnull.getReplacedMessage("選択通知書12"));
        entity.setSelectTsuchisho12(選択通知書12);
        return this;
    }

    /**
     * 選択現金口座12を設定します。
     *
     * @param 選択現金口座12 選択現金口座12
     * @return {@link TsuchishoUchiwakeJokenBuilder}
     */
    public TsuchishoUchiwakeJokenBuilder set選択現金口座12(RString 選択現金口座12) {
        requireNonNull(選択現金口座12, UrSystemErrorMessages.値がnull.getReplacedMessage("選択現金口座12"));
        entity.setSelectGenkinKoza12(選択現金口座12);
        return this;
    }

    /**
     * 出力順グループ名12を設定します。
     *
     * @param 出力順グループ名12 出力順グループ名12
     * @return {@link TsuchishoUchiwakeJokenBuilder}
     */
    public TsuchishoUchiwakeJokenBuilder set出力順グループ名12(RString 出力順グループ名12) {
        requireNonNull(出力順グループ名12, UrSystemErrorMessages.値がnull.getReplacedMessage("出力順グループ名12"));
        entity.setSortGroupName12(出力順グループ名12);
        return this;
    }

    /**
     * 選択通知書13を設定します。
     *
     * @param 選択通知書13 選択通知書13
     * @return {@link TsuchishoUchiwakeJokenBuilder}
     */
    public TsuchishoUchiwakeJokenBuilder set選択通知書13(RString 選択通知書13) {
        requireNonNull(選択通知書13, UrSystemErrorMessages.値がnull.getReplacedMessage("選択通知書13"));
        entity.setSelectTsuchisho13(選択通知書13);
        return this;
    }

    /**
     * 選択現金口座13を設定します。
     *
     * @param 選択現金口座13 選択現金口座13
     * @return {@link TsuchishoUchiwakeJokenBuilder}
     */
    public TsuchishoUchiwakeJokenBuilder set選択現金口座13(RString 選択現金口座13) {
        requireNonNull(選択現金口座13, UrSystemErrorMessages.値がnull.getReplacedMessage("選択現金口座13"));
        entity.setSelectGenkinKoza13(選択現金口座13);
        return this;
    }

    /**
     * 出力順グループ名13を設定します。
     *
     * @param 出力順グループ名13 出力順グループ名13
     * @return {@link TsuchishoUchiwakeJokenBuilder}
     */
    public TsuchishoUchiwakeJokenBuilder set出力順グループ名13(RString 出力順グループ名13) {
        requireNonNull(出力順グループ名13, UrSystemErrorMessages.値がnull.getReplacedMessage("出力順グループ名13"));
        entity.setSortGroupName13(出力順グループ名13);
        return this;
    }

    /**
     * 選択通知書14を設定します。
     *
     * @param 選択通知書14 選択通知書14
     * @return {@link TsuchishoUchiwakeJokenBuilder}
     */
    public TsuchishoUchiwakeJokenBuilder set選択通知書14(RString 選択通知書14) {
        requireNonNull(選択通知書14, UrSystemErrorMessages.値がnull.getReplacedMessage("選択通知書14"));
        entity.setSelectTsuchisho14(選択通知書14);
        return this;
    }

    /**
     * 選択現金口座14を設定します。
     *
     * @param 選択現金口座14 選択現金口座14
     * @return {@link TsuchishoUchiwakeJokenBuilder}
     */
    public TsuchishoUchiwakeJokenBuilder set選択現金口座14(RString 選択現金口座14) {
        requireNonNull(選択現金口座14, UrSystemErrorMessages.値がnull.getReplacedMessage("選択現金口座14"));
        entity.setSelectGenkinKoza14(選択現金口座14);
        return this;
    }

    /**
     * 出力順グループ名14を設定します。
     *
     * @param 出力順グループ名14 出力順グループ名14
     * @return {@link TsuchishoUchiwakeJokenBuilder}
     */
    public TsuchishoUchiwakeJokenBuilder set出力順グループ名14(RString 出力順グループ名14) {
        requireNonNull(出力順グループ名14, UrSystemErrorMessages.値がnull.getReplacedMessage("出力順グループ名14"));
        entity.setSortGroupName14(出力順グループ名14);
        return this;
    }

    /**
     * 選択通知書15を設定します。
     *
     * @param 選択通知書15 選択通知書15
     * @return {@link TsuchishoUchiwakeJokenBuilder}
     */
    public TsuchishoUchiwakeJokenBuilder set選択通知書15(RString 選択通知書15) {
        requireNonNull(選択通知書15, UrSystemErrorMessages.値がnull.getReplacedMessage("選択通知書15"));
        entity.setSelectTsuchisho15(選択通知書15);
        return this;
    }

    /**
     * 選択現金口座15を設定します。
     *
     * @param 選択現金口座15 選択現金口座15
     * @return {@link TsuchishoUchiwakeJokenBuilder}
     */
    public TsuchishoUchiwakeJokenBuilder set選択現金口座15(RString 選択現金口座15) {
        requireNonNull(選択現金口座15, UrSystemErrorMessages.値がnull.getReplacedMessage("選択現金口座15"));
        entity.setSelectGenkinKoza15(選択現金口座15);
        return this;
    }

    /**
     * 出力順グループ名15を設定します。
     *
     * @param 出力順グループ名15 出力順グループ名15
     * @return {@link TsuchishoUchiwakeJokenBuilder}
     */
    public TsuchishoUchiwakeJokenBuilder set出力順グループ名15(RString 出力順グループ名15) {
        requireNonNull(出力順グループ名15, UrSystemErrorMessages.値がnull.getReplacedMessage("出力順グループ名15"));
        entity.setSortGroupName15(出力順グループ名15);
        return this;
    }

    /**
     * {@link TsuchishoUchiwakeJoken}のインスタンスを生成します。
     *
     * @return {@link TsuchishoUchiwakeJoken}のインスタンス
     */
    public TsuchishoUchiwakeJoken build() {
        return new TsuchishoUchiwakeJoken(entity, id);
    }
}
