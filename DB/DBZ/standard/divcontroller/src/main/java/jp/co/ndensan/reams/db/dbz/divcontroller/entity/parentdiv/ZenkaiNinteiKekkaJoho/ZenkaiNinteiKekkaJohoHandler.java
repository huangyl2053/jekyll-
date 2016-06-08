/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.ZenkaiNinteiKekkaJoho;

//import jp.co.ndensan.reams.db.dbz.definition.core.util.optional.Optional;
import jp.co.ndensan.reams.uz.uza.lang.RString;

//import jp.co.ndensan.reams.db.dbz.business.core.INinteiShinseiJoho;
//import jp.co.ndensan.reams.db.dbz.business.core.IShinseiRirekiJoho;
//import jp.co.ndensan.reams.db.dbz.business.core.INinteiKekkaJoho;
//import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.KoroshoInterfaceShikibetsuCode;
//import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.YokaigoJotaiKubunSupport;
//import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
//import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
//import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 前回認定結果の共有子Divのエンティティに対する操作を行うクラスです。
 *
 * @author n8223　朴義一
 */
public class ZenkaiNinteiKekkaJohoHandler {

    private final ZenkaiNinteiKekkaJohoDiv div;
//    private IShinseiRirekiManager shinseiRirekiManager;
//    private INinteiShinseiJohoManager ninteiShinseiJohoManager;
//    private INinteiKekkaJohoManager ninteiKekkaJohoManager;
//    private SubGyomuCode subGyomuCode;

    /**
     * コンストラクタです。
     *
     * @param zenkaiNinteiKekkaJohoDiv 前回認定結果共有子のエンティティ
     */
    public ZenkaiNinteiKekkaJohoHandler(ZenkaiNinteiKekkaJohoDiv zenkaiNinteiKekkaJohoDiv) {
        this.div = zenkaiNinteiKekkaJohoDiv;
        //TODO n2810 checkstyle回避のため暫定対応
        this.div.getTxtYokaigodo().setLabelRText(RString.EMPTY);
//        this.subGyomuCode = new SubGyomuCode(div.getHdnDatabaseSubGyomuCode());
    }

    /**
     * 前回認定値を照会するボタンを押下時のイベントです。<br/>
     * 前回認定結果の情報を取得します。
     */
    public void onClickBtnZenkaiJohoShosaiGuide() {

//       createZenkaiNinteiKekkaJohoManager();
//        Optional<IShinseiRirekiJoho> shinseiRirekiJoho = shinseiRirekiManager.find申請履歴情報(new ShinseishoKanriNo(div.getHdnShinseishoKanriNo()));
//        if (shinseiRirekiJoho.isPresent()) {
//            createZenkaiNinteiKekkaJoho(shinseiRirekiJoho);
//        }
    }

//    private void createZenkaiNinteiKekkaJoho(Optional<IShinseiRirekiJoho> shinseiRirekiJoho) {

//        Optional<INinteiShinseiJoho> ninteiShinseiJoho
//                = ninteiShinseiJohoManager.find認定申請情報(shinseiRirekiJoho.get().get前回申請管理番号());
//        if (!ninteiShinseiJoho.isPresent()) {
//            return;
//        }
//        Optional<INinteiKekkaJoho> ninteiKekkaJoho
//                = ninteiKekkaJohoManager.find要介護認定結果情報(ninteiShinseiJoho.get().get申請書管理番号());
//        if (ninteiKekkaJoho.isPresent()) {
//            if (!KoroshoInterfaceShikibetsuCode.toValue(ninteiShinseiJoho.get().get厚労省IF識別コード().value()).getCode().isEmpty()) {
//                div.getTxtYokaigodo().setValue(YokaigoJotaiKubunSupport.toValue(KoroshoInterfaceShikibetsuCode
//                        .toValue(ninteiShinseiJoho.get().get厚労省IF識別コード().value()), ninteiKekkaJoho.get().get二次判定要介護状態区分コード().value()).getName());
//                div.getTxtNinteiDay().setValue(ninteiKekkaJoho.get().get二次判定年月日());
//                div.getTxtYukoKikanFrom().setValue(ninteiKekkaJoho.get().get二次判定認定有効開始年月日());
//                div.getTxtYukoKikanTo().setValue(ninteiKekkaJoho.get().get二次判定認定有効終了年月日());
//            }
//        }
//    }

//    private static RString nullToStr(RString str) {
//        RString afterStr;
//        if (str == null) {
//            afterStr = RString.EMPTY;
//        } else {
//            afterStr = str;
//        }
//        return afterStr;
//    }

//    private void createZenkaiNinteiKekkaJohoManager() {
//        shinseiRirekiManager = ShinseiRirekiFactory.getInstance(new SubGyomuCode(div.getHdnDatabaseSubGyomuCode()));
//        ninteiShinseiJohoManager = NinteiShinseiJohoManagerFactory.createInstance(new SubGyomuCode(div.getHdnDatabaseSubGyomuCode()));
//        ninteiKekkaJohoManager = NinteiKekkaJohoFactory.getInstance(new SubGyomuCode(div.getHdnDatabaseSubGyomuCode()));
//    }

    /**
     * ロード時のイベントです。
     */
    public void onLoad() {
    }

    /**
     * 初期化処理を行います。
     */
    public void initialize() {
    }

}
