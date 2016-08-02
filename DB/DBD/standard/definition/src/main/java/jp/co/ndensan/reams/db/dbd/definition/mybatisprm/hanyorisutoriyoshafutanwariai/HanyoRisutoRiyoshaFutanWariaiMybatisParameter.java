/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.mybatisprm.hanyorisutoriyoshafutanwariai;

import jp.co.ndensan.reams.db.dbd.definition.batchprm.hanyolist.jukyukyotsu.ChushutsuHohoKubun;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.hanyolist.atena.AtenaSelectBatchParameter;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.hanyolist.atena.Chiku;
import jp.co.ndensan.reams.db.dbz.definition.core.futanwariai.FutanwariaiKubun;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 汎用リスト出力(利用者負担割合)のMyBatis用パラメータクラスです。
 *
 * @reamsid_L DBD-5810-030 mawy
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class HanyoRisutoRiyoshaFutanWariaiMybatisParameter implements IMyBatisParameter {

    private RString cyusyutsuhohokubun;
    private FlexibleYear nendo;
    private FlexibleDate kizyunnichi;
    private boolean isJigyotaishoshafutanichiwari;
    private boolean isJigyotaishoshafutanniwari;
    private boolean isNendochokindatacyusyutsu;
    private boolean isCsvkomokumeifuka;
    private boolean isCsvrenbanfuka;
    private boolean isCsvhitsukesurasyuhensyu;
    private AtenaSelectBatchParameter atenacyusyutsujyoken;
    private RString syutsuryokujun;
    private FutanwariaiKubun 負担割合区分_１割;
    private FutanwariaiKubun 負担割合区分_２割;
    private boolean is基準日;
    private boolean is年度;
    private boolean is事業対象者負担１割;
    private boolean is事業対象者負担２割;
    private boolean has市町村コード;
    private RString 市町村コード;
    private RString 地区選択コードFrom;
    private RString 地区選択コードTo;
    private boolean is住所;
    private boolean has町域From;
    private boolean has町域To;
    private boolean is行政区;
    private boolean has行政区From;
    private boolean has行政区To;
    private boolean is地区;
    private boolean has地区１From;
    private boolean has地区１To;
    private boolean has地区２From;
    private boolean has地区２To;
    private boolean has地区３From;
    private boolean has地区３To;
    private final RString psmShikibetsuTaisho;
    private final RString psmAtesaki;

    /**
     * コンストラクタです。
     *
     * @param cyusyutsuhohokubun 抽出方法区分
     * @param nendo 年度
     * @param kizyunnichi 基準日
     * @param isJigyotaishoshafutanichiwari 事業対象者負担１割
     * @param isJigyotaishoshafutanniwari 事業対象者負担２割
     * @param isNendochokindatacyusyutsu 年度直近データ抽出
     * @param isCsvkomokumeifuka CSV項目名付加
     * @param isCsvrenbanfuka CSV連番付加
     * @param isCsvhitsukesurasyuhensyu CSV日付スラッシュ編集
     * @param atenacyusyutsujyoken 宛名抽出条件
     * @param syutsuryokujun 出力順
     * @param psmShikibetsuTaisho 宛名識別対象PSM
     * @param psmAtesaki 宛名識別対象PSM
     */
    public HanyoRisutoRiyoshaFutanWariaiMybatisParameter(RString cyusyutsuhohokubun, FlexibleYear nendo, FlexibleDate kizyunnichi,
            boolean isJigyotaishoshafutanichiwari, boolean isJigyotaishoshafutanniwari, boolean isNendochokindatacyusyutsu,
            boolean isCsvkomokumeifuka, boolean isCsvrenbanfuka, boolean isCsvhitsukesurasyuhensyu, AtenaSelectBatchParameter atenacyusyutsujyoken,
            RString syutsuryokujun, RString psmShikibetsuTaisho, RString psmAtesaki) {
        this.cyusyutsuhohokubun = cyusyutsuhohokubun;
        this.nendo = nendo;
        this.kizyunnichi = kizyunnichi;
        this.isJigyotaishoshafutanichiwari = isJigyotaishoshafutanichiwari;
        this.isJigyotaishoshafutanniwari = isJigyotaishoshafutanniwari;
        this.isNendochokindatacyusyutsu = isNendochokindatacyusyutsu;
        this.isCsvkomokumeifuka = isCsvkomokumeifuka;
        this.isCsvrenbanfuka = isCsvrenbanfuka;
        this.isCsvhitsukesurasyuhensyu = isCsvhitsukesurasyuhensyu;
        this.atenacyusyutsujyoken = atenacyusyutsujyoken;
        this.syutsuryokujun = syutsuryokujun;
        this.psmShikibetsuTaisho = psmShikibetsuTaisho;
        this.psmAtesaki = psmAtesaki;
        this.負担割合区分_１割 = FutanwariaiKubun._１割;
        this.負担割合区分_２割 = FutanwariaiKubun._２割;
        set抽出方法区分();
        set市町村コード();
        set地区区分();
    }

    private void set抽出方法区分() {
        if (ChushutsuHohoKubun.年度.getコード().equals(cyusyutsuhohokubun)
                && nullHandan(nendo)
                && isNendochokindatacyusyutsu) {
            is年度 = true;
        }
        if (ChushutsuHohoKubun.基準日.getコード().equals(cyusyutsuhohokubun) && nullHandan(kizyunnichi)) {
            is基準日 = true;
        }
    }

    private void set市町村コード() {
        if (nullHandan(atenacyusyutsujyoken.getShichoson_Code())) {
            has市町村コード = true;
            市町村コード = atenacyusyutsujyoken.getShichoson_Code().code市町村RString();
        }
    }

    private void set地区区分() {
        if (Chiku.住所.equals(atenacyusyutsujyoken.getChiku_Kubun())) {
            is住所 = true;
            if (nullHandan(atenacyusyutsujyoken.getJusho_From())) {
                地区選択コードFrom = atenacyusyutsujyoken.getJusho_From();
                has町域From = true;
            }
            if (nullHandan(atenacyusyutsujyoken.getJusho_To())) {
                地区選択コードTo = atenacyusyutsujyoken.getJusho_To();
                has町域To = true;
            }
        } else if (Chiku.行政区.equals(atenacyusyutsujyoken.getChiku_Kubun())) {
            is行政区 = true;
            if (nullHandan(atenacyusyutsujyoken.getGyoseiku_From())) {
                地区選択コードFrom = atenacyusyutsujyoken.getGyoseiku_From();
                has行政区From = true;
            }
            if (nullHandan(atenacyusyutsujyoken.getGyoseiku_To())) {
                地区選択コードTo = atenacyusyutsujyoken.getGyoseiku_To();
                has行政区To = true;
            }
        } else if (Chiku.地区.equals(atenacyusyutsujyoken.getChiku_Kubun())) {
            is地区 = true;
            if (nullHandan(atenacyusyutsujyoken.getChiku1_From())) {
                地区選択コードFrom = atenacyusyutsujyoken.getChiku1_From();
                has地区１From = true;
            }
            if (nullHandan(atenacyusyutsujyoken.getChiku1_To())) {
                地区選択コードTo = atenacyusyutsujyoken.getChiku1_To();
                has地区１To = true;
            }
            if (nullHandan(atenacyusyutsujyoken.getChiku2_From())) {
                地区選択コードFrom = atenacyusyutsujyoken.getChiku2_From();
                has地区２From = true;
            }
            if (nullHandan(atenacyusyutsujyoken.getChiku2_To())) {
                地区選択コードTo = atenacyusyutsujyoken.getChiku2_To();
                has地区２To = true;
            }
            if (nullHandan(atenacyusyutsujyoken.getChiku3_From())) {
                地区選択コードFrom = atenacyusyutsujyoken.getChiku3_From();
                has地区３From = true;
            }
            if (nullHandan(atenacyusyutsujyoken.getChiku3_To())) {
                地区選択コードTo = atenacyusyutsujyoken.getChiku3_To();
                has地区３To = true;
            }
        }
    }

    private static boolean nullHandan(RString handan) {
        return handan != null && !handan.isEmpty();
    }

    private static boolean nullHandan(LasdecCode 市町村コード) {
        return 市町村コード != null && !市町村コード.isEmpty();
    }

    private static boolean nullHandan(FlexibleYear 年度) {
        return 年度 != null;
    }

    private static boolean nullHandan(FlexibleDate 基準日) {
        return 基準日 != null;
    }
}
