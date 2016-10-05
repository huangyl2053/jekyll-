/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.processprm.hanyolistfukadaicho;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.hanyolistfukadaicho.HanyoListDaichoMybatisParameter;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.hanyolist.atena.AtenaSelectBatchParameter;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * バッチ設計_DBBBT22001_汎用リスト 賦課台帳ProcessParameterのクラス
 *
 * @reamsid_L DBB-1900-030 zhaowei
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HanyoListFukaDaichoProcessParameter implements IBatchProcessParameter {

    private ReportId 帳票ID;
    private AtenaSelectBatchParameter 宛名抽出条件;
    private long 出力順ID;
    private RString 出力項目ID;
    private boolean 項目名付加;
    private boolean 連番付加;
    private boolean 日付編集;
    private FlexibleYear 調定年度;
    private FlexibleYear 賦課年度;
    private boolean 最新状態で抽出;
    private RDate 基準日;
    private RString 基準日区分;
    private RString 資格区分;
    private RString 受給者判定;
    private RString 徴収方法;
    private List<RString> 保険料段階s;
    private IShikibetsuTaishoPSMSearchKey 宛名検索条件;

    private RDate システム日付;
    private RString 保険者コード;
    private RString 賦課基準日で抽出;
    private RString 調定日で抽出;
    private RString 資格取得者のみ;
    private RString 資格喪失者のみ;
    private RString 受給者のみ;
    private RString 有効無効区分;
    private RString 出力順;

    /**
     * コンストラクタ
     *
     * @param 宛名検索条件 IShikibetsuTaishoPSMSearchKey
     */
    public HanyoListFukaDaichoProcessParameter(IShikibetsuTaishoPSMSearchKey 宛名検索条件) {
        this.宛名検索条件 = 宛名検索条件;
    }

    /**
     * コンストラクタ
     *
     * @param 帳票ID ReportId
     * @param 宛名抽出条件 AtenaSelectBatchParameter
     * @param 出力順ID long
     * @param 出力項目ID RString
     * @param 項目名付加 boolean
     * @param 連番付加 boolean
     * @param 日付編集 boolean
     * @param 調定年度 FlexibleYear
     * @param 賦課年度 FlexibleYear
     * @param 最新状態で抽出 boolean
     * @param 基準日 RDate
     * @param 徴収方法 RString
     * @param 資格区分 RString
     * @param 基準日区分 RString
     * @param 受給者判定 RString
     * @param 保険料段階s List<RString>
     */
    public HanyoListFukaDaichoProcessParameter(ReportId 帳票ID, AtenaSelectBatchParameter 宛名抽出条件, long 出力順ID,
            RString 出力項目ID, boolean 項目名付加, boolean 連番付加, boolean 日付編集, FlexibleYear 調定年度, FlexibleYear 賦課年度,
            boolean 最新状態で抽出, RDate 基準日, RString 基準日区分, RString 資格区分, RString 受給者判定, RString 徴収方法,
            List<RString> 保険料段階s) {
        this.帳票ID = 帳票ID;
        this.宛名抽出条件 = 宛名抽出条件;
        this.出力順ID = 出力順ID;
        this.出力項目ID = 出力項目ID;
        this.項目名付加 = 項目名付加;
        this.連番付加 = 連番付加;
        this.日付編集 = 日付編集;
        this.調定年度 = 調定年度;
        this.賦課年度 = 賦課年度;
        this.最新状態で抽出 = 最新状態で抽出;
        this.基準日 = 基準日;
        this.基準日区分 = 基準日区分;
        this.資格区分 = 資格区分;
        this.受給者判定 = 受給者判定;
        this.徴収方法 = 徴収方法;
        this.保険料段階s = 保険料段階s;
    }

    /**
     * toMybatisParameter
     *
     * @return HanyoListDaichoMybatisParameter
     */
    public HanyoListDaichoMybatisParameter toMybatisParameter() {
        return new HanyoListDaichoMybatisParameter(調定年度, 賦課年度, 最新状態で抽出,
                基準日, 基準日区分, 保険料段階s, 保険者コード, 資格区分, 受給者判定, システム日付,
                賦課基準日で抽出, 調定日で抽出, 資格取得者のみ, 資格喪失者のみ, 受給者のみ,
                有効無効区分, 宛名抽出条件, 宛名検索条件, 出力順);
    }
}
