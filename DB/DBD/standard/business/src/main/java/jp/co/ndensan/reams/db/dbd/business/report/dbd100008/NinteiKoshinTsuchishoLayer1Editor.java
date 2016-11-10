/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd100008;

import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.futangendogakunintei.KyuSochishaKubun;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd100008.NinteiKoshinTsuchishoReportSource;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.business.report.util.EditedKojin;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7067ChohyoSeigyoHanyoEntity;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringUtil;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 負担限度額認定更新のお知らせ通知書
 *
 * @reamsid_L DBD-3570-040 liangbc
 */
public class NinteiKoshinTsuchishoLayer1Editor implements INinteiKoshinTsuchishoEditor {

    private final NinteiKoshinTsuchishoItem item;
    private static final RString REPLACE_4 = new RString("＠＠＠＠");
    private static final RString REPLACE_11 = new RString("＠＠＠＠＠＠＠＠＠＠＠");
    private final RString unsetBunshoNo = new RString("第            号");

    /**
     * インスタンスを生成します。
     *
     * @param item パラメータ
     */
    protected NinteiKoshinTsuchishoLayer1Editor(NinteiKoshinTsuchishoItem item) {
        this.item = item;
    }

    @Override
    @SuppressWarnings("empty-statement")
    public NinteiKoshinTsuchishoReportSource edit(NinteiKoshinTsuchishoReportSource source) {
        if (item.get文書番号().length() <= 2) {
            source.bunshoNo = unsetBunshoNo;
        } else {
            source.bunshoNo = item.get文書番号();
        }
        for (DbT7067ChohyoSeigyoHanyoEntity entity : item.get帳票制御汎用List()) {
            if (item.get帳票情報() == null || KyuSochishaKubun.非該当.getコード().equals(item.get帳票情報().get旧措置者区分())) {
                if (new RString(ChohyoSeigyoHanyoKeysDBD100008.帳票タイトル.name()).equals(entity.getKomokuName())) {
                    source.title = entity.getKomokuValue();
                    break;
                }
            } else {
                if (new RString(ChohyoSeigyoHanyoKeysDBD100008.帳票タイトル_旧措置者用.name()).equals(entity.getKomokuName())) {
                    source.title = entity.getKomokuValue();
                    break;
                }
            }
        }
        EditedKojin 編集後個人 = getEditedKojin(item.getIKojin(), item.get帳票制御共通(), item.get地方公共団体());
        source.hihokenshaNameKana = 編集後個人.get名称().getKana().getColumnValue();
        source.hihokenshaName = 編集後個人.get名称().getName().getColumnValue();
        source.hihokenshaNo = item.get帳票情報() == null ? RString.EMPTY : item.get帳票情報().get被保険者番号().getColumnValue();
        if (item.get通知書定型文List().size() < 1) {
            source.tsuchibun = RString.EMPTY;
        } else if (item.get帳票情報().get適用終了年月日() == null || !item.get帳票情報().get適用終了年月日().isValid()) {
            source.tsuchibun = item.get通知書定型文List().get(1);
        } else {
            source.tsuchibun = item.get通知書定型文List().get(1).replace(
                    REPLACE_11, RStringUtil.convert半角to全角(new RString(item.get帳票情報().get適用終了年月日().wareki()
                                    .eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.ZERO)
                                    .toDateString().toString()))).replace(
                            REPLACE_4, RStringUtil.convert半角to全角(new RString(item.get帳票情報().get適用終了年月日().wareki()
                                            .eraType(EraType.KANJI).getYear().toString())));
        }
        return source;
    }

    private static EditedKojin getEditedKojin(IKojin kojin, ChohyoSeigyoKyotsu 帳票制御共通, Association 地方公共団体) {
        return new EditedKojin(kojin, 帳票制御共通, 地方公共団体);
    }
}
