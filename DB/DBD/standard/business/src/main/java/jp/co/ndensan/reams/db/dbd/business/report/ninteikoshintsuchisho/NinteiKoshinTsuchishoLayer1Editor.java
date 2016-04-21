/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.ninteikoshintsuchisho;

import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.futangendogakunintei.KyuSochishaKubun;
import jp.co.ndensan.reams.db.dbd.entity.report.ninteikoshintsuchisho.NinteiKoshinTsuchisho;
import jp.co.ndensan.reams.db.dbz.business.report.util.EditedKojin;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 負担限度額認定更新のお知らせ通知書
 *
 * @reamsid_L DBD-3570-040 liangbc
 */
public class NinteiKoshinTsuchishoLayer1Editor implements INinteiKoshinTsuchishoEditor {

    private final NinteiKoshinTsuchishoItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item パラメータ
     */
    protected NinteiKoshinTsuchishoLayer1Editor(NinteiKoshinTsuchishoItem item) {
        this.item = item;
    }

    @Override
    public NinteiKoshinTsuchisho edit(NinteiKoshinTsuchisho source) {
        source.bunshoNo = item.get文書番号();
        if (KyuSochishaKubun.非該当.getコード().equals(item.get帳票情報().get旧措置者区分())) {
            source.title = RString.EMPTY;//DBDEnum.帳票制御汎用キーDBD100008.帳票タイトル
        } else {
            source.title = RString.EMPTY;//DBDEnum.帳票制御汎用キーDBD100008.帳票タイトル_旧措置者
        }
        EditedKojin 編集後個人 = getEditedKojin(item.getIKojin());
        source.hihokenshaNameKana = 編集後個人.get名称().getKana().getColumnValue();
        source.hihokenshaName = 編集後個人.get名称().getName().getColumnValue();
        source.hihokenshaNo = item.get帳票情報().get被保険者番号().getColumnValue();
        source.tsuchibun = item.get通知書定型文List().get(1);
        source.shikibetsuCode = item.getIKojin().get識別コード();
        return source;
    }

    private static EditedKojin getEditedKojin(IKojin kojin) {
        return new EditedKojin(kojin);
    }
}
