/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.jigyojokyohokoku;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakaishukeihyo.Shinsakaishukeihyo;
import jp.co.ndensan.reams.db.dbe.definition.processprm.hokokushiryosakusei.ShinsakaishukeihyoHanteiBetsuProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.hokokushiryosakusei.ShinsakaishukeihyoHanteiBetsuEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.hokokushiryosakusei.SinsakaiHanteiJyokyoHeaderEntity;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定事業状況報告の情報です。
 *
 * @reamsid_L DBE-1450-020 wangxiaodong
 */
public class SinsakaiHanteiJyokyoShinsakaishukeihyoEditor {

    private static final RString タイトル = new RString("介護認定審査会集計表（判定別）");
    private static final RString 全市町村 = new RString("全市町村");
    private static final RString 全市町村コード = RString.EMPTY;
    private static final RString 非該当タイトル = new RString("非該当");
    private static final RString 要支援1タイトル = new RString("要支援1");
    private static final RString 要支援2タイトル = new RString("要支援2");
    private static final RString 要介護1タイトル = new RString("要介護1");
    private static final RString 要介護2タイトル = new RString("要介護2");
    private static final RString 要介護3タイトル = new RString("要介護3");
    private static final RString 要介護4タイトル = new RString("要介護4");
    private static final RString 要介護5タイトル = new RString("要介護5");
    private static final RString 計タイトル = new RString("計");
    private static final RString 非該当 = new RString("01");
    private static final RString 要支援1 = new RString("12");
    private static final RString 要支援2 = new RString("13");
    private static final RString 要介護1 = new RString("21");
    private static final RString 要介護2 = new RString("22");
    private static final RString 要介護3 = new RString("23");
    private static final RString 要介護4 = new RString("24");
    private static final RString 要介護5 = new RString("25");
    private final ShinsakaishukeihyoHanteiBetsuProcessParameter parameter;
    private final SinsakaiHanteiJyokyoHeaderEntity entity;
    private final Shinsakaishukeihyo shinsakaishukeihyo;

    /**
     * コンストラクタです。
     *
     * @param parameter ShinsakaishukeihyoHanteiBetsuProcessParameter
     * @param entity SinsakaiHanteiJyokyoHeaderEntity
     * @param shinsakaishukeihyo Shinsakaishukeihyo
     */
    public SinsakaiHanteiJyokyoShinsakaishukeihyoEditor(
            ShinsakaishukeihyoHanteiBetsuProcessParameter parameter,
            SinsakaiHanteiJyokyoHeaderEntity entity,
            Shinsakaishukeihyo shinsakaishukeihyo) {
        this.parameter = parameter;
        this.entity = entity;
        this.shinsakaishukeihyo = shinsakaishukeihyo;
    }

    /**
     * 介護認定審査会判定状況を設定します。
     *
     * @param 審査会集計表 List<ShinsakaishukeihyoHanteiBetsuEntity>
     */
    public void set介護認定審査会集計表判定別(List<ShinsakaishukeihyoHanteiBetsuEntity> 審査会集計表) {
        setヘッダ情報(entity);
        set前回非該当(審査会集計表);
        set前回要支援1(審査会集計表);
        set前回要支援2(審査会集計表);
        set前回要介護1(審査会集計表);
        set前回要介護2(審査会集計表);
        set前回要介護3(審査会集計表);
        set前回要介護4(審査会集計表);
        set前回要介護5(審査会集計表);
        set計();
    }

    private void setヘッダ情報(SinsakaiHanteiJyokyoHeaderEntity current) {
        shinsakaishukeihyo.setタイトル(タイトル);
        shinsakaishukeihyo.set審査会開始年月日(parameter.getTaishoGeppiFrom());
        shinsakaishukeihyo.set審査会終了年月日(parameter.getTaishoGeppiTo());
        shinsakaishukeihyo.set開催回数(new RString(current.getShinsakaiKaisaiNoCount()));
        if (RString.isNullOrEmpty(parameter.getShichosonCode().value())) {
            shinsakaishukeihyo.set市町村名(全市町村);
            shinsakaishukeihyo.set市町村コード(全市町村コード);
        } else {
            shinsakaishukeihyo.set市町村名(parameter.getShichosonName());
            shinsakaishukeihyo.set市町村コード(parameter.getShichosonCode().value());
        }
        shinsakaishukeihyo.set発行日時(RDateTime.now());
        shinsakaishukeihyo.set二次判定非該当タイトル(非該当タイトル);
        shinsakaishukeihyo.set二次判定要支援1タイトル(要支援1タイトル);
        shinsakaishukeihyo.set二次判定要支援2タイトル(要支援2タイトル);
        shinsakaishukeihyo.set二次判定要介護1タイトル(要介護1タイトル);
        shinsakaishukeihyo.set二次判定要介護2タイトル(要介護2タイトル);
        shinsakaishukeihyo.set二次判定要介護3タイトル(要介護3タイトル);
        shinsakaishukeihyo.set二次判定要介護4タイトル(要介護4タイトル);
        shinsakaishukeihyo.set二次判定要介護5タイトル(要介護5タイトル);
        shinsakaishukeihyo.set前回二次判定_計タイトル(計タイトル);
    }

    private void set前回非該当(List<ShinsakaishukeihyoHanteiBetsuEntity> 審査会集計表) {
        shinsakaishukeihyo.set前回二次判定非該当タイトル(非該当タイトル);
        shinsakaishukeihyo.set前回二次判定非該当_二次判定非該当(new RString(get被保険者数(審査会集計表, 非該当, 非該当)));
        shinsakaishukeihyo.set前回二次判定非該当_二次判定要支援1(new RString(get被保険者数(審査会集計表, 非該当, 要支援1)));
        shinsakaishukeihyo.set前回二次判定非該当_二次判定要支援2(new RString(get被保険者数(審査会集計表, 非該当, 要支援2)));
        shinsakaishukeihyo.set前回二次判定非該当_二次判定要介護1(new RString(get被保険者数(審査会集計表, 非該当, 要介護1)));
        shinsakaishukeihyo.set前回二次判定非該当_二次判定要介護2(new RString(get被保険者数(審査会集計表, 非該当, 要介護2)));
        shinsakaishukeihyo.set前回二次判定非該当_二次判定要介護3(new RString(get被保険者数(審査会集計表, 非該当, 要介護3)));
        shinsakaishukeihyo.set前回二次判定非該当_二次判定要介護4(new RString(get被保険者数(審査会集計表, 非該当, 要介護4)));
        shinsakaishukeihyo.set前回二次判定非該当_二次判定要介護5(new RString(get被保険者数(審査会集計表, 非該当, 要介護5)));
        set前回二次判定非該当_計();
    }

    private void set前回二次判定非該当_計() {
        shinsakaishukeihyo.set前回二次判定非該当_計(new RString(
                getIntValue(shinsakaishukeihyo.get前回二次判定非該当_二次判定非該当())
                + getIntValue(shinsakaishukeihyo.get前回二次判定非該当_二次判定要支援1())
                + getIntValue(shinsakaishukeihyo.get前回二次判定非該当_二次判定要支援2())
                + getIntValue(shinsakaishukeihyo.get前回二次判定非該当_二次判定要介護1())
                + getIntValue(shinsakaishukeihyo.get前回二次判定非該当_二次判定要介護2())
                + getIntValue(shinsakaishukeihyo.get前回二次判定非該当_二次判定要介護3())
                + getIntValue(shinsakaishukeihyo.get前回二次判定非該当_二次判定要介護4())
                + getIntValue(shinsakaishukeihyo.get前回二次判定非該当_二次判定要介護5())));
    }

    private void set前回要支援1(List<ShinsakaishukeihyoHanteiBetsuEntity> 審査会集計表) {
        shinsakaishukeihyo.set前回二次判定要支援1タイトル(要支援1タイトル);
        shinsakaishukeihyo.set前回二次判定要支援1_二次判定非該当(new RString(get被保険者数(審査会集計表, 要支援1, 非該当)));
        shinsakaishukeihyo.set前回二次判定要支援1_二次判定要支援1(new RString(get被保険者数(審査会集計表, 要支援1, 要支援1)));
        shinsakaishukeihyo.set前回二次判定要支援1_二次判定要支援2(new RString(get被保険者数(審査会集計表, 要支援1, 要支援2)));
        shinsakaishukeihyo.set前回二次判定要支援1_二次判定要介護1(new RString(get被保険者数(審査会集計表, 要支援1, 要介護1)));
        shinsakaishukeihyo.set前回二次判定要支援1_二次判定要介護2(new RString(get被保険者数(審査会集計表, 要支援1, 要介護2)));
        shinsakaishukeihyo.set前回二次判定要支援1_二次判定要介護3(new RString(get被保険者数(審査会集計表, 要支援1, 要介護3)));
        shinsakaishukeihyo.set前回二次判定要支援1_二次判定要介護4(new RString(get被保険者数(審査会集計表, 要支援1, 要介護4)));
        shinsakaishukeihyo.set前回二次判定要支援1_二次判定要介護5(new RString(get被保険者数(審査会集計表, 要支援1, 要介護5)));
        set前回二次判定要支援1_計();
    }

    private void set前回二次判定要支援1_計() {
        shinsakaishukeihyo.set前回二次判定要支援1_計(new RString(
                getIntValue(shinsakaishukeihyo.get前回二次判定要支援1_二次判定非該当())
                + getIntValue(shinsakaishukeihyo.get前回二次判定要支援1_二次判定要支援1())
                + getIntValue(shinsakaishukeihyo.get前回二次判定要支援1_二次判定要支援2())
                + getIntValue(shinsakaishukeihyo.get前回二次判定要支援1_二次判定要介護1())
                + getIntValue(shinsakaishukeihyo.get前回二次判定要支援1_二次判定要介護2())
                + getIntValue(shinsakaishukeihyo.get前回二次判定要支援1_二次判定要介護3())
                + getIntValue(shinsakaishukeihyo.get前回二次判定要支援1_二次判定要介護4())
                + getIntValue(shinsakaishukeihyo.get前回二次判定要支援1_二次判定要介護5())));
    }

    private void set前回要支援2(List<ShinsakaishukeihyoHanteiBetsuEntity> 審査会集計表) {
        shinsakaishukeihyo.set前回二次判定要支援2タイトル(要支援2タイトル);
        shinsakaishukeihyo.set前回二次判定要支援2_二次判定非該当(new RString(get被保険者数(審査会集計表, 要支援2, 非該当)));
        shinsakaishukeihyo.set前回二次判定要支援2_二次判定要支援1(new RString(get被保険者数(審査会集計表, 要支援2, 要支援1)));
        shinsakaishukeihyo.set前回二次判定要支援2_二次判定要支援2(new RString(get被保険者数(審査会集計表, 要支援2, 要支援2)));
        shinsakaishukeihyo.set前回二次判定要支援2_二次判定要介護1(new RString(get被保険者数(審査会集計表, 要支援2, 要介護1)));
        shinsakaishukeihyo.set前回二次判定要支援2_二次判定要介護2(new RString(get被保険者数(審査会集計表, 要支援2, 要介護2)));
        shinsakaishukeihyo.set前回二次判定要支援2_二次判定要介護3(new RString(get被保険者数(審査会集計表, 要支援2, 要介護3)));
        shinsakaishukeihyo.set前回二次判定要支援2_二次判定要介護4(new RString(get被保険者数(審査会集計表, 要支援2, 要介護4)));
        shinsakaishukeihyo.set前回二次判定要支援2_二次判定要介護5(new RString(get被保険者数(審査会集計表, 要支援2, 要介護5)));
        set前回二次判定要支援2_計();
    }

    private void set前回二次判定要支援2_計() {
        shinsakaishukeihyo.set前回二次判定要支援2_計(new RString(
                getIntValue(shinsakaishukeihyo.get前回二次判定要支援2_二次判定非該当())
                + getIntValue(shinsakaishukeihyo.get前回二次判定要支援2_二次判定要支援1())
                + getIntValue(shinsakaishukeihyo.get前回二次判定要支援2_二次判定要支援2())
                + getIntValue(shinsakaishukeihyo.get前回二次判定要支援2_二次判定要介護1())
                + getIntValue(shinsakaishukeihyo.get前回二次判定要支援2_二次判定要介護2())
                + getIntValue(shinsakaishukeihyo.get前回二次判定要支援2_二次判定要介護3())
                + getIntValue(shinsakaishukeihyo.get前回二次判定要支援2_二次判定要介護4())
                + getIntValue(shinsakaishukeihyo.get前回二次判定要支援2_二次判定要介護5())));
    }

    private void set前回要介護1(List<ShinsakaishukeihyoHanteiBetsuEntity> 審査会集計表) {
        shinsakaishukeihyo.set前回二次判定要介護1タイトル(要介護1タイトル);
        shinsakaishukeihyo.set前回二次判定要介護1_二次判定非該当(new RString(get被保険者数(審査会集計表, 要介護1, 非該当)));
        shinsakaishukeihyo.set前回二次判定要介護1_二次判定要支援1(new RString(get被保険者数(審査会集計表, 要介護1, 要支援1)));
        shinsakaishukeihyo.set前回二次判定要介護1_二次判定要支援2(new RString(get被保険者数(審査会集計表, 要介護1, 要支援2)));
        shinsakaishukeihyo.set前回二次判定要介護1_二次判定要介護1(new RString(get被保険者数(審査会集計表, 要介護1, 要介護1)));
        shinsakaishukeihyo.set前回二次判定要介護1_二次判定要介護2(new RString(get被保険者数(審査会集計表, 要介護1, 要介護2)));
        shinsakaishukeihyo.set前回二次判定要介護1_二次判定要介護3(new RString(get被保険者数(審査会集計表, 要介護1, 要介護3)));
        shinsakaishukeihyo.set前回二次判定要介護1_二次判定要介護4(new RString(get被保険者数(審査会集計表, 要介護1, 要介護4)));
        shinsakaishukeihyo.set前回二次判定要介護1_二次判定要介護5(new RString(get被保険者数(審査会集計表, 要介護1, 要介護5)));
        set前回二次判定要介護1_計();
    }

    private void set前回二次判定要介護1_計() {
        shinsakaishukeihyo.set前回二次判定要介護1_計(new RString(
                getIntValue(shinsakaishukeihyo.get前回二次判定要介護1_二次判定非該当())
                + getIntValue(shinsakaishukeihyo.get前回二次判定要介護1_二次判定要支援1())
                + getIntValue(shinsakaishukeihyo.get前回二次判定要介護1_二次判定要支援2())
                + getIntValue(shinsakaishukeihyo.get前回二次判定要介護1_二次判定要介護1())
                + getIntValue(shinsakaishukeihyo.get前回二次判定要介護1_二次判定要介護2())
                + getIntValue(shinsakaishukeihyo.get前回二次判定要介護1_二次判定要介護3())
                + getIntValue(shinsakaishukeihyo.get前回二次判定要介護1_二次判定要介護4())
                + getIntValue(shinsakaishukeihyo.get前回二次判定要介護1_二次判定要介護5())));
    }

    private void set前回要介護2(List<ShinsakaishukeihyoHanteiBetsuEntity> 審査会集計表) {
        shinsakaishukeihyo.set前回二次判定要介護2タイトル(要介護2タイトル);
        shinsakaishukeihyo.set前回二次判定要介護2_二次判定非該当(new RString(get被保険者数(審査会集計表, 要介護2, 非該当)));
        shinsakaishukeihyo.set前回二次判定要介護2_二次判定要支援1(new RString(get被保険者数(審査会集計表, 要介護2, 要支援1)));
        shinsakaishukeihyo.set前回二次判定要介護2_二次判定要支援2(new RString(get被保険者数(審査会集計表, 要介護2, 要支援2)));
        shinsakaishukeihyo.set前回二次判定要介護2_二次判定要介護1(new RString(get被保険者数(審査会集計表, 要介護2, 要介護1)));
        shinsakaishukeihyo.set前回二次判定要介護2_二次判定要介護2(new RString(get被保険者数(審査会集計表, 要介護2, 要介護2)));
        shinsakaishukeihyo.set前回二次判定要介護2_二次判定要介護3(new RString(get被保険者数(審査会集計表, 要介護2, 要介護3)));
        shinsakaishukeihyo.set前回二次判定要介護2_二次判定要介護4(new RString(get被保険者数(審査会集計表, 要介護2, 要介護4)));
        shinsakaishukeihyo.set前回二次判定要介護2_二次判定要介護5(new RString(get被保険者数(審査会集計表, 要介護2, 要介護5)));
        set前回二次判定要介護2_計();
    }

    private void set前回二次判定要介護2_計() {
        shinsakaishukeihyo.set前回二次判定要介護2_計(new RString(
                getIntValue(shinsakaishukeihyo.get前回二次判定要介護2_二次判定非該当())
                + getIntValue(shinsakaishukeihyo.get前回二次判定要介護2_二次判定要支援1())
                + getIntValue(shinsakaishukeihyo.get前回二次判定要介護2_二次判定要支援2())
                + getIntValue(shinsakaishukeihyo.get前回二次判定要介護2_二次判定要介護1())
                + getIntValue(shinsakaishukeihyo.get前回二次判定要介護2_二次判定要介護2())
                + getIntValue(shinsakaishukeihyo.get前回二次判定要介護2_二次判定要介護3())
                + getIntValue(shinsakaishukeihyo.get前回二次判定要介護2_二次判定要介護4())
                + getIntValue(shinsakaishukeihyo.get前回二次判定要介護2_二次判定要介護5())));
    }

    private void set前回要介護3(List<ShinsakaishukeihyoHanteiBetsuEntity> 審査会集計表) {
        shinsakaishukeihyo.set前回二次判定要介護3タイトル(要介護3タイトル);
        shinsakaishukeihyo.set前回二次判定要介護3_二次判定非該当(new RString(get被保険者数(審査会集計表, 要介護3, 非該当)));
        shinsakaishukeihyo.set前回二次判定要介護3_二次判定要支援1(new RString(get被保険者数(審査会集計表, 要介護3, 要支援1)));
        shinsakaishukeihyo.set前回二次判定要介護3_二次判定要支援2(new RString(get被保険者数(審査会集計表, 要介護3, 要支援2)));
        shinsakaishukeihyo.set前回二次判定要介護3_二次判定要介護1(new RString(get被保険者数(審査会集計表, 要介護3, 要介護1)));
        shinsakaishukeihyo.set前回二次判定要介護3_二次判定要介護2(new RString(get被保険者数(審査会集計表, 要介護3, 要介護2)));
        shinsakaishukeihyo.set前回二次判定要介護3_二次判定要介護3(new RString(get被保険者数(審査会集計表, 要介護3, 要介護3)));
        shinsakaishukeihyo.set前回二次判定要介護3_二次判定要介護4(new RString(get被保険者数(審査会集計表, 要介護3, 要介護4)));
        shinsakaishukeihyo.set前回二次判定要介護3_二次判定要介護5(new RString(get被保険者数(審査会集計表, 要介護3, 要介護5)));
        set前回二次判定要介護3_計();
    }

    private void set前回二次判定要介護3_計() {
        shinsakaishukeihyo.set前回二次判定要介護3_計(new RString(
                getIntValue(shinsakaishukeihyo.get前回二次判定要介護3_二次判定非該当())
                + getIntValue(shinsakaishukeihyo.get前回二次判定要介護3_二次判定要支援1())
                + getIntValue(shinsakaishukeihyo.get前回二次判定要介護3_二次判定要支援2())
                + getIntValue(shinsakaishukeihyo.get前回二次判定要介護3_二次判定要介護1())
                + getIntValue(shinsakaishukeihyo.get前回二次判定要介護3_二次判定要介護2())
                + getIntValue(shinsakaishukeihyo.get前回二次判定要介護3_二次判定要介護3())
                + getIntValue(shinsakaishukeihyo.get前回二次判定要介護3_二次判定要介護4())
                + getIntValue(shinsakaishukeihyo.get前回二次判定要介護3_二次判定要介護5())));
    }

    private void set前回要介護4(List<ShinsakaishukeihyoHanteiBetsuEntity> 審査会集計表) {
        shinsakaishukeihyo.set前回二次判定要介護4タイトル(要介護4タイトル);
        shinsakaishukeihyo.set前回二次判定要介護4_二次判定非該当(new RString(get被保険者数(審査会集計表, 要介護4, 非該当)));
        shinsakaishukeihyo.set前回二次判定要介護4_二次判定要支援1(new RString(get被保険者数(審査会集計表, 要介護4, 要支援1)));
        shinsakaishukeihyo.set前回二次判定要介護4_二次判定要支援2(new RString(get被保険者数(審査会集計表, 要介護4, 要支援2)));
        shinsakaishukeihyo.set前回二次判定要介護4_二次判定要介護1(new RString(get被保険者数(審査会集計表, 要介護4, 要介護1)));
        shinsakaishukeihyo.set前回二次判定要介護4_二次判定要介護2(new RString(get被保険者数(審査会集計表, 要介護4, 要介護2)));
        shinsakaishukeihyo.set前回二次判定要介護4_二次判定要介護3(new RString(get被保険者数(審査会集計表, 要介護4, 要介護3)));
        shinsakaishukeihyo.set前回二次判定要介護4_二次判定要介護4(new RString(get被保険者数(審査会集計表, 要介護4, 要介護4)));
        shinsakaishukeihyo.set前回二次判定要介護4_二次判定要介護5(new RString(get被保険者数(審査会集計表, 要介護4, 要介護5)));
        set前回二次判定要介護4_計();
    }

    private void set前回二次判定要介護4_計() {
        shinsakaishukeihyo.set前回二次判定要介護4_計(new RString(
                getIntValue(shinsakaishukeihyo.get前回二次判定要介護4_二次判定非該当())
                + getIntValue(shinsakaishukeihyo.get前回二次判定要介護4_二次判定要支援1())
                + getIntValue(shinsakaishukeihyo.get前回二次判定要介護4_二次判定要支援2())
                + getIntValue(shinsakaishukeihyo.get前回二次判定要介護4_二次判定要介護1())
                + getIntValue(shinsakaishukeihyo.get前回二次判定要介護4_二次判定要介護2())
                + getIntValue(shinsakaishukeihyo.get前回二次判定要介護4_二次判定要介護3())
                + getIntValue(shinsakaishukeihyo.get前回二次判定要介護4_二次判定要介護4())
                + getIntValue(shinsakaishukeihyo.get前回二次判定要介護4_二次判定要介護5())));
    }

    private void set前回要介護5(List<ShinsakaishukeihyoHanteiBetsuEntity> 審査会集計表) {
        shinsakaishukeihyo.set前回二次判定要介護5タイトル(要介護5タイトル);
        shinsakaishukeihyo.set前回二次判定要介護5_二次判定非該当(new RString(get被保険者数(審査会集計表, 要介護5, 非該当)));
        shinsakaishukeihyo.set前回二次判定要介護5_二次判定要支援1(new RString(get被保険者数(審査会集計表, 要介護5, 要支援1)));
        shinsakaishukeihyo.set前回二次判定要介護5_二次判定要支援2(new RString(get被保険者数(審査会集計表, 要介護5, 要支援2)));
        shinsakaishukeihyo.set前回二次判定要介護5_二次判定要介護1(new RString(get被保険者数(審査会集計表, 要介護5, 要介護1)));
        shinsakaishukeihyo.set前回二次判定要介護5_二次判定要介護2(new RString(get被保険者数(審査会集計表, 要介護5, 要介護2)));
        shinsakaishukeihyo.set前回二次判定要介護5_二次判定要介護3(new RString(get被保険者数(審査会集計表, 要介護5, 要介護3)));
        shinsakaishukeihyo.set前回二次判定要介護5_二次判定要介護4(new RString(get被保険者数(審査会集計表, 要介護5, 要介護4)));
        shinsakaishukeihyo.set前回二次判定要介護5_二次判定要介護5(new RString(get被保険者数(審査会集計表, 要介護5, 要介護5)));
        set前回二次判定要介護5_計();
    }

    private void set前回二次判定要介護5_計() {
        shinsakaishukeihyo.set前回二次判定要介護5_計(new RString(
                getIntValue(shinsakaishukeihyo.get前回二次判定要介護5_二次判定非該当())
                + getIntValue(shinsakaishukeihyo.get前回二次判定要介護5_二次判定要支援1())
                + getIntValue(shinsakaishukeihyo.get前回二次判定要介護5_二次判定要支援2())
                + getIntValue(shinsakaishukeihyo.get前回二次判定要介護5_二次判定要介護1())
                + getIntValue(shinsakaishukeihyo.get前回二次判定要介護5_二次判定要介護2())
                + getIntValue(shinsakaishukeihyo.get前回二次判定要介護5_二次判定要介護3())
                + getIntValue(shinsakaishukeihyo.get前回二次判定要介護5_二次判定要介護4())
                + getIntValue(shinsakaishukeihyo.get前回二次判定要介護5_二次判定要介護5())));
    }

    private void set計() {
        shinsakaishukeihyo.set計タイトル(計タイトル);
        shinsakaishukeihyo.set計_二次判定非該当(new RString(
                getIntValue(shinsakaishukeihyo.get前回二次判定非該当_二次判定非該当())
                + getIntValue(shinsakaishukeihyo.get前回二次判定要支援1_二次判定非該当())
                + getIntValue(shinsakaishukeihyo.get前回二次判定要支援2_二次判定非該当())
                + getIntValue(shinsakaishukeihyo.get前回二次判定要介護1_二次判定非該当())
                + getIntValue(shinsakaishukeihyo.get前回二次判定要介護2_二次判定非該当())
                + getIntValue(shinsakaishukeihyo.get前回二次判定要介護3_二次判定非該当())
                + getIntValue(shinsakaishukeihyo.get前回二次判定要介護4_二次判定非該当())
                + getIntValue(shinsakaishukeihyo.get前回二次判定要介護5_二次判定非該当())));
        shinsakaishukeihyo.set計_二次判定要支援1(new RString(
                getIntValue(shinsakaishukeihyo.get前回二次判定非該当_二次判定要支援1())
                + getIntValue(shinsakaishukeihyo.get前回二次判定要支援1_二次判定要支援1())
                + getIntValue(shinsakaishukeihyo.get前回二次判定要支援2_二次判定要支援1())
                + getIntValue(shinsakaishukeihyo.get前回二次判定要介護1_二次判定要支援1())
                + getIntValue(shinsakaishukeihyo.get前回二次判定要介護2_二次判定要支援1())
                + getIntValue(shinsakaishukeihyo.get前回二次判定要介護3_二次判定要支援1())
                + getIntValue(shinsakaishukeihyo.get前回二次判定要介護4_二次判定要支援1())
                + getIntValue(shinsakaishukeihyo.get前回二次判定要介護5_二次判定要支援1())));
        shinsakaishukeihyo.set計_二次判定要支援2(new RString(
                getIntValue(shinsakaishukeihyo.get前回二次判定非該当_二次判定要支援2())
                + getIntValue(shinsakaishukeihyo.get前回二次判定要支援1_二次判定要支援2())
                + getIntValue(shinsakaishukeihyo.get前回二次判定要支援2_二次判定要支援2())
                + getIntValue(shinsakaishukeihyo.get前回二次判定要介護1_二次判定要支援2())
                + getIntValue(shinsakaishukeihyo.get前回二次判定要介護2_二次判定要支援2())
                + getIntValue(shinsakaishukeihyo.get前回二次判定要介護3_二次判定要支援2())
                + getIntValue(shinsakaishukeihyo.get前回二次判定要介護4_二次判定要支援2())
                + getIntValue(shinsakaishukeihyo.get前回二次判定要介護5_二次判定要支援2())));
        shinsakaishukeihyo.set計_二次判定要介護1(new RString(
                getIntValue(shinsakaishukeihyo.get前回二次判定非該当_二次判定要介護1())
                + getIntValue(shinsakaishukeihyo.get前回二次判定要支援1_二次判定要介護1())
                + getIntValue(shinsakaishukeihyo.get前回二次判定要支援2_二次判定要介護1())
                + getIntValue(shinsakaishukeihyo.get前回二次判定要介護1_二次判定要介護1())
                + getIntValue(shinsakaishukeihyo.get前回二次判定要介護2_二次判定要介護1())
                + getIntValue(shinsakaishukeihyo.get前回二次判定要介護3_二次判定要介護1())
                + getIntValue(shinsakaishukeihyo.get前回二次判定要介護4_二次判定要介護1())
                + getIntValue(shinsakaishukeihyo.get前回二次判定要介護5_二次判定要介護1())));
        shinsakaishukeihyo.set計_二次判定要介護2(new RString(
                getIntValue(shinsakaishukeihyo.get前回二次判定非該当_二次判定要介護2())
                + getIntValue(shinsakaishukeihyo.get前回二次判定要支援1_二次判定要介護2())
                + getIntValue(shinsakaishukeihyo.get前回二次判定要支援2_二次判定要介護2())
                + getIntValue(shinsakaishukeihyo.get前回二次判定要介護1_二次判定要介護2())
                + getIntValue(shinsakaishukeihyo.get前回二次判定要介護2_二次判定要介護2())
                + getIntValue(shinsakaishukeihyo.get前回二次判定要介護3_二次判定要介護2())
                + getIntValue(shinsakaishukeihyo.get前回二次判定要介護4_二次判定要介護2())
                + getIntValue(shinsakaishukeihyo.get前回二次判定要介護5_二次判定要介護2())));
        shinsakaishukeihyo.set計_二次判定要介護3(new RString(
                getIntValue(shinsakaishukeihyo.get前回二次判定非該当_二次判定要介護3())
                + getIntValue(shinsakaishukeihyo.get前回二次判定要支援1_二次判定要介護3())
                + getIntValue(shinsakaishukeihyo.get前回二次判定要支援2_二次判定要介護3())
                + getIntValue(shinsakaishukeihyo.get前回二次判定要介護1_二次判定要介護3())
                + getIntValue(shinsakaishukeihyo.get前回二次判定要介護2_二次判定要介護3())
                + getIntValue(shinsakaishukeihyo.get前回二次判定要介護3_二次判定要介護3())
                + getIntValue(shinsakaishukeihyo.get前回二次判定要介護4_二次判定要介護3())
                + getIntValue(shinsakaishukeihyo.get前回二次判定要介護5_二次判定要介護3())));
        shinsakaishukeihyo.set計_二次判定要介護4(new RString(
                getIntValue(shinsakaishukeihyo.get前回二次判定非該当_二次判定要介護4())
                + getIntValue(shinsakaishukeihyo.get前回二次判定要支援1_二次判定要介護4())
                + getIntValue(shinsakaishukeihyo.get前回二次判定要支援2_二次判定要介護4())
                + getIntValue(shinsakaishukeihyo.get前回二次判定要介護1_二次判定要介護4())
                + getIntValue(shinsakaishukeihyo.get前回二次判定要介護2_二次判定要介護4())
                + getIntValue(shinsakaishukeihyo.get前回二次判定要介護3_二次判定要介護4())
                + getIntValue(shinsakaishukeihyo.get前回二次判定要介護4_二次判定要介護4())
                + getIntValue(shinsakaishukeihyo.get前回二次判定要介護5_二次判定要介護4())));
        shinsakaishukeihyo.set計_二次判定要介護5(new RString(
                getIntValue(shinsakaishukeihyo.get前回二次判定非該当_二次判定要介護5())
                + getIntValue(shinsakaishukeihyo.get前回二次判定要支援1_二次判定要介護5())
                + getIntValue(shinsakaishukeihyo.get前回二次判定要支援2_二次判定要介護5())
                + getIntValue(shinsakaishukeihyo.get前回二次判定要介護1_二次判定要介護5())
                + getIntValue(shinsakaishukeihyo.get前回二次判定要介護2_二次判定要介護5())
                + getIntValue(shinsakaishukeihyo.get前回二次判定要介護3_二次判定要介護5())
                + getIntValue(shinsakaishukeihyo.get前回二次判定要介護4_二次判定要介護5())
                + getIntValue(shinsakaishukeihyo.get前回二次判定要介護5_二次判定要介護5())));
        set計_計();
    }

    private void set計_計() {
        shinsakaishukeihyo.set計_計(new RString(
                getIntValue(shinsakaishukeihyo.get計_二次判定非該当())
                + getIntValue(shinsakaishukeihyo.get計_二次判定要支援1())
                + getIntValue(shinsakaishukeihyo.get計_二次判定要支援2())
                + getIntValue(shinsakaishukeihyo.get計_二次判定要介護1())
                + getIntValue(shinsakaishukeihyo.get計_二次判定要介護2())
                + getIntValue(shinsakaishukeihyo.get計_二次判定要介護3())
                + getIntValue(shinsakaishukeihyo.get計_二次判定要介護4())
                + getIntValue(shinsakaishukeihyo.get計_二次判定要介護5())));
    }

    private int get被保険者数(List<ShinsakaishukeihyoHanteiBetsuEntity> 審査会集計表,
            RString 前回二次判定結果コード, RString 今回二次判定結果コード) {
        for (ShinsakaishukeihyoHanteiBetsuEntity hanteiBetsuEntity : 審査会集計表) {
            if (hanteiBetsuEntity.getZenkaiNijiHantei().value().equals(前回二次判定結果コード)
                    && hanteiBetsuEntity.getKonkaiNijiHantei().value().equals(今回二次判定結果コード)) {
                return hanteiBetsuEntity.getHihokenshaCount();
            }
        }
        return 0;
    }

    private int getIntValue(RString 被保険者数) {
        if (RString.isNullOrEmpty(被保険者数)) {
            return 0;
        }
        return Integer.parseInt(被保険者数.toString());
    }
}
