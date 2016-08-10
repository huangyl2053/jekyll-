/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.processprm.hoshushiharaijunbipanel;

import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.hoshushiharaijunbipanel.HoshushiharaiJumbiPanelBatchMybitisParameter;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.ShoriJotaiKubun;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 支払いデータ作成のProcess用パラメータクラスです。
 *
 * @reamsid_L DBE-1990-020 lizhuoxuan
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HoshushiharaiJumbiPanelProcessParamter implements IBatchProcessParameter {

    private final FlexibleDate jissekidaterangefrom;
    private final FlexibleDate jissekidaterangeto;
    private final FlexibleDate furikomishiteiday;
    private final RString chkchosa;
    private final RString chkshujii;
    private final RString chkshinsakai;

    /**
     * コンストラクタ作成です。
     *
     * @param jissekidaterangefrom 実績期間From
     * @param jissekidaterangeto 実績期間To
     * @param furikomishiteiday 振込指定日
     * @param chkchosa 認定調査報酬対象
     * @param chkshujii 主治医意見書作成報酬対象
     * @param chkshinsakai 審査会委員報酬対象
     */
    public HoshushiharaiJumbiPanelProcessParamter(FlexibleDate jissekidaterangefrom,
            FlexibleDate jissekidaterangeto,
            FlexibleDate furikomishiteiday,
            RString chkchosa,
            RString chkshujii,
            RString chkshinsakai) {
        this.jissekidaterangefrom = jissekidaterangefrom;
        this.jissekidaterangeto = jissekidaterangeto;
        this.furikomishiteiday = furikomishiteiday;
        this.chkchosa = chkchosa;
        this.chkshujii = chkshujii;
        this.chkshinsakai = chkshinsakai;
    }

    /**
     * Mybatisのパラメータを作成します。
     *
     * @return HoshushiharaiJumbiPanelBatchMybitisParameter
     */
    public HoshushiharaiJumbiPanelBatchMybitisParameter toHoshushiharaiJumbiPanelBatchMybitisParameter() {

        RString 報酬基準日 = DbBusinessConfig.get(ConfigNameDBE.主治医意見書報酬基準日, RDate.getNowDate(),
                SubGyomuCode.DBE認定支援);
        return HoshushiharaiJumbiPanelBatchMybitisParameter.creatParameter(jissekidaterangefrom,
                jissekidaterangeto,
                furikomishiteiday,
                ShoriJotaiKubun.通常.getコード(),
                ShoriJotaiKubun.延期.getコード(),
                報酬基準日,
                new RString("1").equals(報酬基準日));
    }
}
