/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd100018;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.shafukukeigen.ShakaifukuRiyoshaFutanKeigen;
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
 * 社会福祉法人等利用者負担軽減対象確認証
 *
 * @reamsid_L DBD-3540-100 wangchao
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShakfukusRiysFutKeigTaisKakuninshoItem {

    private final ShakaifukuRiyoshaFutanKeigen 社会福祉法人等利用者負担軽減;
    private final IKojin iKojin;
    private final IAtesaki iAtesaki;
    private final ChohyoSeigyoKyotsu 帳票制御共通;
    private final List<DbT7067ChohyoSeigyoHanyoEntity> 帳票制御汎用List;
    private final Association 地方公共団体;
    private final RDate 交付日;
    private final ReportId 帳票分類ID;
    private final Ninshosha 認証者;
    private RString イメージファイルパス;
    private EditedAtesaki 編集後宛先;

    /**
     * インスタンスを生成します。
     *
     * @param 社会福祉法人等利用者負担軽減 社会福祉法人等利用者負担軽減
     * @param iKojin iKojin
     * @param iAtesaki iAtesaki
     * @param 帳票制御共通 帳票制御共通
     * @param 帳票制御汎用List 帳票制御汎用List
     * @param 地方公共団体 地方公共団体
     * @param 交付日 交付日
     * @param 帳票分類ID 帳票分類ID
     * @param 認証者 認証者
     */
    public ShakfukusRiysFutKeigTaisKakuninshoItem(ShakaifukuRiyoshaFutanKeigen 社会福祉法人等利用者負担軽減, IKojin iKojin, IAtesaki iAtesaki,
            ChohyoSeigyoKyotsu 帳票制御共通, List<DbT7067ChohyoSeigyoHanyoEntity> 帳票制御汎用List, Association 地方公共団体, RDate 交付日,
            ReportId 帳票分類ID, Ninshosha 認証者) {
        this.社会福祉法人等利用者負担軽減 = 社会福祉法人等利用者負担軽減;
        this.iKojin = iKojin;
        this.iAtesaki = iAtesaki;
        this.帳票制御共通 = 帳票制御共通;
        this.帳票制御汎用List = 帳票制御汎用List;
        this.地方公共団体 = 地方公共団体;
        this.交付日 = 交付日;
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
