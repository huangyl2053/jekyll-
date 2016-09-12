/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchoheijunka6tsuchishoikatsuhako;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 特別徴収平準化仮算定額変更通知書発行一覧表CSVのクラスです。
 *
 * @reamsid_L DBB-0820-040 xuyue
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Setter
@Getter
public class KariSanteigakuHenkoTsuchishoHakkoIchiranData {

    @CsvField(order = 1, name = "作成年月日")
    private RString 作成年月日;
    @CsvField(order = 2, name = "作成日時")
    private RString 作成日時;
    @CsvField(order = 3, name = "年度")
    private RString 年度;
    @CsvField(order = 4, name = "連番")
    private RString 連番;
    @CsvField(order = 5, name = "郵便番号")
    private RString 郵便番号;
    @CsvField(order = 6, name = "住所")
    private RString 住所;
    @CsvField(order = 7, name = "町域（管内）・管外住所")
    private RString 町域管内管外住所;
    @CsvField(order = 8, name = "番地")
    private RString 番地;
    @CsvField(order = 9, name = "行政区コード")
    private RString 行政区コード;
    @CsvField(order = 10, name = "性別")
    private RString 性別;
    @CsvField(order = 11, name = "生年月日")
    private RString 生年月日;
    @CsvField(order = 12, name = "変更前特徴額（１期）")
    private RString 変更前特徴額１期;
    @CsvField(order = 13, name = "変更前特徴額（２期）")
    private RString 変更前特徴額２期;
    @CsvField(order = 14, name = "変更前特徴額（３期）")
    private RString 変更前特徴額３期;
    @CsvField(order = 15, name = "通知書番号")
    private RString 通知書番号;
    @CsvField(order = 16, name = "世帯コード")
    private RString 世帯コード;
    @CsvField(order = 17, name = "被保険者氏名")
    private RString 被保険者氏名;
    @CsvField(order = 18, name = "特別徴収業務者コード")
    private RString 特別徴収業務者コード;
    @CsvField(order = 19, name = "特別徴収業務者")
    private RString 特別徴収業務者;
    @CsvField(order = 20, name = "特別徴収対象年金コード")
    private RString 特別徴収対象年金コード;
    @CsvField(order = 21, name = "特別徴収対象年金")
    private RString 特別徴収対象年金;
    @CsvField(order = 22, name = "変更後特徴額（１期）")
    private RString 変更後特徴額１期;
    @CsvField(order = 23, name = "変更後特徴額（２期）")
    private RString 変更後特徴額２期;
    @CsvField(order = 24, name = "変更後特徴額（３期）")
    private RString 変更後特徴額３期;

    /**
     * メンバ変数を {@code List<RString>} に格納して返します。
     *
     * @return メンバ変数を格納した {@code List<RString>}
     */
    public List<RString> toRStringList() {
        List<RString> list = new ArrayList<>();
        list.add(作成年月日);
        list.add(作成日時);
        list.add(年度);
        list.add(連番);
        list.add(郵便番号);
        list.add(住所);
        list.add(町域管内管外住所);
        list.add(番地);
        list.add(行政区コード);
        list.add(性別);
        list.add(生年月日);
        list.add(変更前特徴額１期);
        list.add(変更前特徴額２期);
        list.add(変更前特徴額３期);
        list.add(通知書番号);
        list.add(世帯コード);
        list.add(被保険者氏名);
        list.add(特別徴収業務者コード);
        list.add(特別徴収業務者);
        list.add(特別徴収対象年金コード);
        list.add(特別徴収対象年金);
        list.add(変更後特徴額１期);
        list.add(変更後特徴額２期);
        list.add(変更後特徴額３期);

        return list;
    }

}
