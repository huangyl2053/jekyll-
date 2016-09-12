/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd100008;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.futangendogakunintei.FutanGendogakuNintei;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.business.report.util.EditedAtesaki;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7067ChohyoSeigyoHanyoEntity;
import jp.co.ndensan.reams.ua.uax.business.core.atesaki.IAtesaki;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.ninshosha.Ninshosha;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 負担限度額認定更新のお知らせ通知書
 *
 * @reamsid_L DBD-3570-040 liangbc
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NinteiKoshinTsuchishoItem {

    private final FutanGendogakuNintei 帳票情報;
    private final IKojin iKojin;
    private final IAtesaki iAtesaki;
    private final ChohyoSeigyoKyotsu 帳票制御共通;
    private final List<DbT7067ChohyoSeigyoHanyoEntity> 帳票制御汎用List;
    private final Association 地方公共団体;
    private final RDate 発行日;
    private final RString 文書番号;
    private final List<RString> 通知書定型文List;
    private final ReportId 帳票分類ID;
    private final Ninshosha 認証者;
    private RString イメージファイルパス;
    private EditedAtesaki 編集後宛先;

    /**
     * インスタンスを生成します。
     *
     * @param 帳票情報 帳票情報
     * @param iKojin iKojin
     * @param iAtesaki iAtesaki
     * @param 帳票制御共通 帳票制御共通
     * @param 帳票制御汎用List 帳票制御汎用List
     * @param 地方公共団体 地方公共団体
     * @param 発行日 発行日
     * @param 文書番号 文書番号
     * @param 通知書定型文List 通知書定型文List
     * @param 帳票分類ID 帳票分類ID
     * @param 認証者 認証者
     */
    public NinteiKoshinTsuchishoItem(FutanGendogakuNintei 帳票情報, IKojin iKojin, IAtesaki iAtesaki, ChohyoSeigyoKyotsu 帳票制御共通,
            List<DbT7067ChohyoSeigyoHanyoEntity> 帳票制御汎用List, Association 地方公共団体, RDate 発行日, RString 文書番号,
            List<RString> 通知書定型文List, ReportId 帳票分類ID, Ninshosha 認証者) {
        this.帳票情報 = 帳票情報;
        this.iKojin = iKojin;
        this.iAtesaki = iAtesaki;
        this.帳票制御共通 = 帳票制御共通;
        this.帳票制御汎用List = 帳票制御汎用List;
        this.地方公共団体 = 地方公共団体;
        this.発行日 = 発行日;
        this.文書番号 = 文書番号;
        this.通知書定型文List = 通知書定型文List;
        this.帳票分類ID = 帳票分類ID;
        this.認証者 = 認証者;
    }

    /**
     * 編集後宛先を設定
     *
     * @param 編集後宛先 編集後宛先
     */
    public void set編集後宛先(EditedAtesaki 編集後宛先) {
        this.編集後宛先 = 編集後宛先;
    }

    /**
     * イメージファイルパスを設定
     *
     * @param イメージファイルパス イメージファイルパス
     */
    public void setイメージファイルパス(RString イメージファイルパス) {
        this.イメージファイルパス = イメージファイルパス;
    }
}
