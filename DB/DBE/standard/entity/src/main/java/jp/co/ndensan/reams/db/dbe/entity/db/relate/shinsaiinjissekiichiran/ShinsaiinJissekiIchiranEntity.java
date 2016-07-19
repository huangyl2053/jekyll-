/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsaiinjissekiichiran;

import jp.co.ndensan.reams.db.dbe.definition.core.shinsakai.IsShusseki;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 介護認定審査会委員報酬実績集計表のCsvのEntityを作成。
 *
 * @reamsid_L DBE-1700-020 wanghuafeng
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShinsaiinJissekiIchiranEntity implements IShinsaiinJissekiIchiranCsvEucEntity {

    @CsvField(order = 1, name = "コード")
    private final RString コード;
    @CsvField(order = 2, name = "氏名")
    private final RString 氏名;
    @CsvField(order = 3, name = "報酬区分")
    private final RString 報酬区分;
    @CsvField(order = 4, name = "所属機関")
    private final RString 所属機関;
    @CsvField(order = 5, name = "審査会地区")
    private final RString 審査会地区;
    @CsvField(order = 6, name = "審査会番号")
    private final RString 審査会番号;
    @CsvField(order = 7, name = "実施日")
    private final RString 実施日;
    @CsvField(order = 8, name = "開始")
    private final RString 開始;
    @CsvField(order = 9, name = "終了")
    private final RString 終了;
    @CsvField(order = 10, name = "審査員種別")
    private final RString 審査員種別;
    @CsvField(order = 11, name = "出欠")
    private final RString 出欠;
    @CsvField(order = 12, name = "実施年月日")
    private final RString 実施年月日;
    @CsvField(order = 13, name = "連番")
    private final RString 連番;

    /**
     * コンストラクタです。
     *
     * @param relateEntity ShinsaiinJissekiIchiranRelateEntity
     */
    public ShinsaiinJissekiIchiranEntity(ShinsaiinJissekiIchiranRelateEntity relateEntity) {
        this.コード = relateEntity.getコード();
        this.氏名 = relateEntity.get氏名();
        this.報酬区分 = relateEntity.get報酬区分();
        this.所属機関 = relateEntity.get所属機関();
        this.審査会地区 = relateEntity.get審査会地区();
        this.審査会番号 = relateEntity.get審査会番号();
        this.実施日 = relateEntity.get実施日();
        this.開始 = relateEntity.get開始();
        this.終了 = relateEntity.get終了();
        this.審査員種別 = relateEntity.get審査員種別();
        this.出欠 = IsShusseki.toValue(relateEntity.is出欠()).get名称();
        this.実施年月日 = relateEntity.get実施年月日();
        this.連番 = new RString(relateEntity.get連番());

    }
}
