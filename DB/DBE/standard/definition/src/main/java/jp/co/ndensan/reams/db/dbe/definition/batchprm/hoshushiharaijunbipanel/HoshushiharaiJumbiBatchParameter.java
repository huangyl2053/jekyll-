/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.batchprm.hoshushiharaijunbipanel;

import jp.co.ndensan.reams.db.dbe.definition.processprm.hoshushiharaijunbipanel.HoshushiharaiJumbiPanelProcessParamter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 支払いデータ作成のバチパラメータクラスです。
 *
 * @reamsid_L DBE-1990-020 lizhuoxuan
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class HoshushiharaiJumbiBatchParameter extends BatchParameterBase {

    private static final long serialVersionUID = 5507196526569627897L;
    private static final String JISSEKIDATERANGE_FROM = "jissekidaterangefrom";
    private static final String JISSEKIDATERANGE_TO = "jissekidaterangeto";
    private static final String FURIKOMI_SHITEIDAY = "furikomishiteiday";
    private static final String CHK_CHOSA = "sakusedate";
    private static final String CHK_SHUJII = "chkshujii";
    private static final String CHK_SHINSAKAI = "chkshinsakai";

    @BatchParameter(key = JISSEKIDATERANGE_FROM, name = "実績期間From")
    private FlexibleDate jissekidaterangefrom;
    @BatchParameter(key = JISSEKIDATERANGE_TO, name = "実績期間To")
    private FlexibleDate jissekidaterangeto;
    @BatchParameter(key = FURIKOMI_SHITEIDAY, name = "振込指定日")
    private FlexibleDate furikomishiteiday;
    @BatchParameter(key = CHK_CHOSA, name = "作成データ対象_認定調査対象")
    private RString sakusedate;
    @BatchParameter(key = CHK_SHUJII, name = "作成データ対象_主治医意見書作成報酬対象")
    private RString chkshujii;
    @BatchParameter(key = CHK_SHINSAKAI, name = "作成データ対象_審査会委員報酬対象")
    private RString chkshinsakai;

    /**
     * コンストラクタです。
     */
    public HoshushiharaiJumbiBatchParameter() {

    }

    /**
     * コンストラクタです。
     *
     * @param jissekidaterangefrom 実績期間From
     * @param jissekidaterangeto 実績期間To
     * @param furikomishiteiday 振込指定日
     * @param sakusedate 作成データ対象_認定調査対象
     * @param chkshujii 作成データ対象_主治医意見書作成報酬対象
     * @param chkshinsakai 作成データ対象_審査会委員報酬対象
     */
    public HoshushiharaiJumbiBatchParameter(
            FlexibleDate jissekidaterangefrom,
            FlexibleDate jissekidaterangeto,
            FlexibleDate furikomishiteiday,
            RString sakusedate,
            RString chkshujii,
            RString chkshinsakai) {
        this.jissekidaterangefrom = jissekidaterangefrom;
        this.jissekidaterangeto = jissekidaterangeto;
        this.furikomishiteiday = furikomishiteiday;
        this.sakusedate = sakusedate;
        this.chkshujii = chkshujii;
        this.chkshinsakai = chkshinsakai;

    }

    /**
     * processのパラメータを生成します。
     *
     * @return HoshushiharaiJumbiPanelProcessParamter
     */
    public HoshushiharaiJumbiPanelProcessParamter toHoshushiharaiJumbiPanelProcessParamter() {
        return new HoshushiharaiJumbiPanelProcessParamter(jissekidaterangefrom,
                jissekidaterangeto,
                furikomishiteiday,
                sakusedate,
                chkshujii,
                chkshinsakai);
    }
}
