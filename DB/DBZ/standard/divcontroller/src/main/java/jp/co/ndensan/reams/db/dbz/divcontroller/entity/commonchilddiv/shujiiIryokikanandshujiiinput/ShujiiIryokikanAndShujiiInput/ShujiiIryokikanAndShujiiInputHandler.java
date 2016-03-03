/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.shujiiIryokikanandshujiiinput.ShujiiIryokikanAndShujiiInput;

//import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ShujiiCode;
import java.util.ArrayList;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.business.core.shujiiiryokikanandshujiiinput.ShujiiIryokikanAndShujiiInputResult;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

//import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ShujiiIryokikanCode;
/**
 * 共有子Div「主治医医療機関＆主治医入力」のhandlerクラスです
 *
 */
public class ShujiiIryokikanAndShujiiInputHandler {

    private final ShujiiIryokikanAndShujiiInputDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 主治医医療機関＆主治医入力Div
     */
    public ShujiiIryokikanAndShujiiInputHandler(ShujiiIryokikanAndShujiiInputDiv div) {
        this.div = div;
    }

    /**
     * 主治医医療機関＆主治医入力Divの初期化です。
     *
     * @param shichosonCode 市町村コード
     * @param shinseishoKanriNo 申請書管理番号
     * @param gyomuCode サブ業務コード
     */
    public void initialize(LasdecCode shichosonCode, ShinseishoKanriNo shinseishoKanriNo, SubGyomuCode gyomuCode) {
        div.getTxtIryoKikanCode().clearValue();
        div.getTxtIryoKikanName().clearValue();
        div.getTxtShujiiCode().clearValue();
        div.getTxtShujiiName().clearValue();
        div.getChkShiteii().setSelectedItemsByKey(new ArrayList<RString>());
        div.setHdnShichosonCode(shichosonCode.value());
        div.setHdnShinseishoKanriNo(shinseishoKanriNo.value());
        div.setHdnSubGyomuModel(gyomuCode.value());
    }

    /**
     * 前回申請情報をセットします。
     *
     * @param 前回申請情報
     */
    public void setZenkaiIrokikanJoho(ShujiiIryokikanAndShujiiInputResult 前回申請情報) {
        div.getTxtShujiiName().setValue(前回申請情報.get主治医氏名() == null
                ? RString.EMPTY : 前回申請情報.get主治医氏名().value());
        div.getTxtIryoKikanName().setValue(前回申請情報.get主治医医療機関名称());
        div.getTxtIryoKikanCode().setValue(前回申請情報.get主治医医療機関コード());
        div.getTxtShujiiCode().setValue(前回申請情報.get主治医コード());
        if (前回申請情報.is指定医フラグ()) {
            div.getChkShiteii().setSelectedItems(div.getChkShiteii().getDataSource());
        }
    }

    /**
     * 主治医医療機関名前をセットします。
     *
     * @param 主治医医療機関名称
     */
    public void setIryoKikanName(RString 主治医医療機関名称) {
        div.getTxtIryoKikanName().setValue(主治医医療機関名称);
    }

    /**
     * 主治医氏名をセットします。
     *
     * @param 主治医氏名
     */
    public void setShujiiName(AtenaMeisho 主治医氏名) {
        div.getTxtShujiiName().setValue(主治医氏名 == null ? RString.EMPTY : 主治医氏名.value());
    }
}
