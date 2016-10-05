/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC710170;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.processprm.hanyolistkogakugassanshikyugakukettei.HanyoListKogakuGassanShikyugakuKetteiProcessParameter;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.koza.IKozaSearchKey;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 汎用リスト出力(高額合算支給額決定情報)バッチ用パラメータクラスです。
 *
 * @reamsid_L DBC-3101-010 qinzhen
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBC710170_HanyoListKogakuGassanShikyugakuKetteiParameter extends BatchParameterBase {

    private IKozaSearchKey searchkey;
    private List<KamokuCode> list;
    private RString reamsLoginId;

    @BatchParameter(key = "支給区分", name = "支給区分")
    private RString 支給区分;
    @BatchParameter(key = "支払方法区分", name = "支払方法区分")
    private RString 支払方法区分;
    @BatchParameter(key = "金融機関コード", name = "金融機関コード")
    private KinyuKikanCode 金融機関コード;
    @BatchParameter(key = "金融機関名称", name = "金融機関名称")
    private RString 金融機関名称;
    @BatchParameter(key = "対象年度", name = "対象年度")
    private RString 対象年度;
    @BatchParameter(key = "決定情報受取年月From", name = "決定情報受取年月From")
    private FlexibleYearMonth 決定情報受取年月From;
    @BatchParameter(key = "決定情報受取年月To", name = "決定情報受取年月To")
    private FlexibleYearMonth 決定情報受取年月To;
    @BatchParameter(key = "項目名付加", name = "項目名付加")
    private boolean 項目名付加;
    @BatchParameter(key = "連番付加", name = "連番付加")
    private boolean 連番付加;
    @BatchParameter(key = "日付スラッシュ付加", name = "日付スラッシュ付加")
    private boolean 日付スラッシュ付加;
    @BatchParameter(key = "保険者コード", name = "保険者コード")
    private LasdecCode 保険者コード;
    @BatchParameter(key = "出力順", name = "出力順")
    private RString 出力順;
    @BatchParameter(key = "出力項目", name = "出力項目")
    private RString 出力項目;

    /**
     * mybatisのパラメータを生成します。
     *
     * @return mybatisパラメータ
     */
    public HanyoListKogakuGassanShikyugakuKetteiProcessParameter toProcessParam() {
        return new HanyoListKogakuGassanShikyugakuKetteiProcessParameter(
                支給区分,
                支払方法区分,
                金融機関コード,
                金融機関名称,
                対象年度,
                決定情報受取年月From,
                決定情報受取年月To,
                項目名付加,
                連番付加,
                日付スラッシュ付加,
                保険者コード,
                出力順,
                出力項目,
                searchkey,
                list,
                reamsLoginId);
    }
}
