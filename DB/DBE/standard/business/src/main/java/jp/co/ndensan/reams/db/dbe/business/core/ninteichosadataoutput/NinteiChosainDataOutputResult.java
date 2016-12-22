/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ninteichosadataoutput;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosadataoutput.NinteiChosainDataRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosadataoutput.NinteiChosainOutputEucCsvEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.codeshubetsu.DBECodeShubetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;

/**
 * 認定調査データ出力（モバイル）特記事項CSVEntity設定のビジネスです。
 */
public class NinteiChosainDataOutputResult {

    private static final RString BOOLEAN_TRUE = new RString("True");
    private static final RString BOOLEAN_FALSE = new RString("False");

    /**
     * EucCsvEntityの設定メッソドです。
     *
     * @param entityParam NinteiChosainDataRelateEntity
     * @param 市町村名 市町村名
     * @return NinteiChosainOutputEucCsvEntity
     */
    public NinteiChosainOutputEucCsvEntity setEucCsvEntity(NinteiChosainDataRelateEntity entityParam, RString 市町村名) {

        NinteiChosainOutputEucCsvEntity eucCsvEntity = new NinteiChosainOutputEucCsvEntity();
        eucCsvEntity.set市町村コード(entityParam.get市町村コード());
        eucCsvEntity.set市町村(市町村名);
        eucCsvEntity.set調査員コード(entityParam.get調査員コード());
        eucCsvEntity.set調査員氏名(entityParam.get調査員氏名());
        eucCsvEntity.set調査員カナ氏名(entityParam.get調査員カナ氏名());
        eucCsvEntity.set調査委託先コード(entityParam.get調査委託先コード());
        eucCsvEntity.set調査委託先名称(entityParam.get事業者名称());
        eucCsvEntity.set性別(Seibetsu.toValue(entityParam.get性別()).get名称());
        eucCsvEntity.set地区コード(entityParam.get地区コード());
        RString 地区名称 = RString.EMPTY;
        if (!RString.isNullOrEmpty(entityParam.get地区コード())) {
            地区名称 = CodeMaster.getCodeMeisho(SubGyomuCode.DBE認定支援, DBECodeShubetsu.調査地区コード.getコード(),
                    new Code(entityParam.get地区コード()), FlexibleDate.getNowDate());
        }
        eucCsvEntity.set地区名称(地区名称);
        eucCsvEntity.set調査員資格(entityParam.get調査員資格());
        eucCsvEntity.set調査可能人数(entityParam.get調査可能人数());
        RString 状況フラグ = convertBoolean(entityParam.get状況フラグ());
        eucCsvEntity.set状況フラグ(状況フラグ);
        eucCsvEntity.set郵便番号(entityParam.get郵便番号());
        eucCsvEntity.set住所(entityParam.get住所());
        eucCsvEntity.set電話番号(entityParam.get電話番号());
        eucCsvEntity.setＦＡＸ番号(entityParam.getＦＡＸ番号());
        eucCsvEntity.set所属機関名称(entityParam.get所属機関名称());
        return eucCsvEntity;
    }

    private RString convertBoolean(RString value) {
        if (new RString("t").equals(value)) {
            return BOOLEAN_TRUE;
        } else if (new RString("f").equals(value)) {
            return BOOLEAN_FALSE;
        }
        return RString.EMPTY;
    }
}
