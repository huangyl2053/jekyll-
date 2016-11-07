/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.mybatisprm.tokuteikojinjohoteikyo;

import jp.co.ndensan.reams.db.dbu.definition.core.bangoseido.DataSetNo;
import jp.co.ndensan.reams.db.dbu.definition.core.bangoseido.ShinkiIdoKubun;
import jp.co.ndensan.reams.db.dbu.definition.core.bangoseido.TeikyoKubun;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 被保険者情報のMyBatis用パラメータクラスです。
 *
 * @reamsid_L DBU-4880-030 zhaoyao
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class HihokenshaJohoMybatisParameter implements IMyBatisParameter {

    private boolean is当初または版改定;
    private boolean is再登録;
    private boolean is異動;
    private RString 新規異動区分;
    private RString 個人番号付替対象者被保険者番号;
    private RDateTime 対象開始日時;
    private RDateTime 対象終了日時;
    private RString データセット番号;
    private RString 提供区分_個人番号未設定により未提供;
    private RString 提供区分_その他エラーにより未提供;
    private RString tempTableName;
    private RString psmShikibetsuTaisho;

    private HihokenshaJohoMybatisParameter(
            boolean is当初または版改定,
            boolean is再登録,
            boolean is異動,
            RString 新規異動区分,
            RString 個人番号付替対象者被保険者番号,
            RDateTime 対象開始日時,
            RDateTime 対象終了日時,
            RString データセット番号,
            RString 提供区分_個人番号未設定により未提供,
            RString 提供区分_その他エラーにより未提供,
            RString tempTableName,
            RString psmShikibetsuTaisho) {
        this.is当初または版改定 = is当初または版改定;
        this.is再登録 = is再登録;
        this.is異動 = is異動;
        this.新規異動区分 = 新規異動区分;
        this.個人番号付替対象者被保険者番号 = 個人番号付替対象者被保険者番号;
        this.対象開始日時 = 対象開始日時;
        this.対象終了日時 = 対象終了日時;
        this.データセット番号 = データセット番号;
        this.提供区分_個人番号未設定により未提供 = 提供区分_個人番号未設定により未提供;
        this.提供区分_その他エラーにより未提供 = 提供区分_その他エラーにより未提供;
        this.tempTableName = tempTableName;
        this.psmShikibetsuTaisho = psmShikibetsuTaisho;
    }

    /**
     * 提供情報_候補のMybatisParameterを生成します。
     *
     * @param 新規異動区分 新規異動区分
     * @param 対象開始日時 対象開始日時
     * @param 対象終了日時 対象終了日時
     * @param 個人番号付替対象者被保険者番号 個人番号付替対象者被保険者番号
     * @return HihokenshaJohoMybatisParameter
     */
    public static HihokenshaJohoMybatisParameter createParamter提供情報_候補(
            RString 新規異動区分,
            RDateTime 対象開始日時,
            RDateTime 対象終了日時,
            RString 個人番号付替対象者被保険者番号) {
        boolean is当初または版改定 = false;
        boolean is再登録 = false;
        boolean is異動 = false;
        if (ShinkiIdoKubun.当初.getコード().equals(新規異動区分)
                || ShinkiIdoKubun.版改定.getコード().equals(新規異動区分)) {
            is当初または版改定 = true;
        }
        if (ShinkiIdoKubun.再登録.getコード().equals(新規異動区分)) {
            is再登録 = true;
        }
        if (ShinkiIdoKubun.異動.getコード().equals(新規異動区分)) {
            is異動 = true;
        }
        return new HihokenshaJohoMybatisParameter(
                is当初または版改定,
                is再登録,
                is異動,
                新規異動区分,
                個人番号付替対象者被保険者番号,
                対象開始日時,
                対象終了日時,
                DataSetNo._0101被保険者情報.getコード(),
                TeikyoKubun.個人番号未設定により未提供.getコード(),
                TeikyoKubun.その他エラーにより未提供.getコード(),
                RString.EMPTY,
                RString.EMPTY
        );
    }

    /**
     * 提供対象者のMybatisParameterを生成します。
     *
     * @param 新規異動区分 新規異動区分
     * @param 宛名 宛名
     * @param テーブル名 テーブル名
     * @return RiyoshaFutanwariaiMybatisParameter
     */
    public static HihokenshaJohoMybatisParameter createParamter提供対象者(RString 新規異動区分,
            RString 宛名, RString テーブル名) {
        boolean is異動 = false;
        if (ShinkiIdoKubun.異動.getコード().equals(新規異動区分)) {
            is異動 = true;
        }
        return new HihokenshaJohoMybatisParameter(
                false,
                false,
                is異動,
                RString.EMPTY,
                RString.EMPTY,
                RDateTime.MAX,
                RDateTime.MAX,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                テーブル名,
                宛名);
    }
}
