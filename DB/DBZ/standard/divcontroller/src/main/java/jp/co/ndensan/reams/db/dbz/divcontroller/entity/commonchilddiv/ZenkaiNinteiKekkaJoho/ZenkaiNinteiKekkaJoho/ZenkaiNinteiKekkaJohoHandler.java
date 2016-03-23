/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ZenkaiNinteiKekkaJoho.ZenkaiNinteiKekkaJoho;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.business.core.HokenshaNinteiShinseiJoho;
import jp.co.ndensan.reams.db.dbz.business.core.ninteishinseirenrakusakijoho.NinteiShinseiJoho;
import jp.co.ndensan.reams.db.dbz.business.core.zenkaininteikekkajoho.ZenkaiNinteiKekkaJohoRelate;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun02;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun06;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun99;
import jp.co.ndensan.reams.db.dbz.service.core.zenkaininteikekkajoho.ZenkaiNinteiKekkaJohoFinder;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 前回結果情報のHandlerクラスです。
 */
public class ZenkaiNinteiKekkaJohoHandler {
    
    private final ZenkaiNinteiKekkaJohoDiv div;
    
    /**
     * コンストラクタです。
     * @param div 画面情報
     */
    public ZenkaiNinteiKekkaJohoHandler(ZenkaiNinteiKekkaJohoDiv div) {
        this.div = div;
    }
    
    /**
     * 前回認定結果Divの初期化です。
     * @param subGyomuCode 画面モード
     * @param shinseishoKanriNo 申請書管理番号
     * @param 参照結果 参照結果
     */
    public void onLoad(SubGyomuCode subGyomuCode,
            ShinseishoKanriNo shinseishoKanriNo,
            RString 参照結果) {
        if (new RString("1").equals(参照結果)) {
            set前回情報(subGyomuCode, shinseishoKanriNo);
        } else if (new RString("2").equals(参照結果)) {
            set今回情報(subGyomuCode, shinseishoKanriNo);
        }
    }
    
    private void set前回情報(SubGyomuCode subGyomuCode,
            ShinseishoKanriNo shinseishoKanriNo) {
        if (SubGyomuCode.DBD介護受給.equals(subGyomuCode)) {
            List<HokenshaNinteiShinseiJoho> hokenshaNinteiShinseiJohoList = getService()
                    .get要介護度_前回受給(shinseishoKanriNo).records();
            if (!hokenshaNinteiShinseiJohoList.isEmpty()) {
                HokenshaNinteiShinseiJoho joho = hokenshaNinteiShinseiJohoList.get(0);
                div.getTxtYokaigodo().setValue(set要介護度(joho.get厚労省IF識別コード().getColumnValue(), joho.get前回要介護状態区分コード()));
                div.getTxtNinteiDay().setValue(joho.get前回認定年月日());
                div.getTxtYukoKikanFrom().setValue(joho.get前回認定有効期間_開始());
                div.getTxtYukoKikanTo().setValue(joho.get前回認定有効期間_終了());
            }
        } else if (SubGyomuCode.DBE認定支援.equals(subGyomuCode)) {
            List<NinteiShinseiJoho> ninteiShinseiJohoList = getService()
                    .get要介護度_前回認定(shinseishoKanriNo).records();
            if (!ninteiShinseiJohoList.isEmpty()) {
                NinteiShinseiJoho joho = ninteiShinseiJohoList.get(0);
                div.getTxtYokaigodo().setValue(set要介護度(joho.get厚労省IF識別コード().getColumnValue(), joho.get前回要介護状態区分コード()));
                div.getTxtNinteiDay().setValue(joho.get前回認定年月日());
                div.getTxtYukoKikanFrom().setValue(joho.get前回認定有効期間_開始_());
                div.getTxtYukoKikanTo().setValue(joho.get前回認定有効期間_終了_());
            }
        }
    }
    
    private void set今回情報(SubGyomuCode subGyomuCode,
            ShinseishoKanriNo shinseishoKanriNo) {
        if (SubGyomuCode.DBD介護受給.equals(subGyomuCode)) {
            List<ZenkaiNinteiKekkaJohoRelate> zenkaiNinteiKekkaJohoRelateList = getService().get要介護度_今回受給(shinseishoKanriNo).records();
            if (!zenkaiNinteiKekkaJohoRelateList.isEmpty()) {
                ZenkaiNinteiKekkaJohoRelate joho = zenkaiNinteiKekkaJohoRelateList.get(0);
                div.getTxtYokaigodo().setValue(set要介護度(joho.get厚労省IF識別コード(), new Code(joho.get二次判定要介護状態区分コード())));
                div.getTxtNinteiDay().setValue(set共通ポリシーパターン1(joho.get次判定年月日()));
                div.getTxtYukoKikanFrom().setValue(set共通ポリシーパターン1(joho.get二次判定認定有効開始年月日()));
                div.getTxtYukoKikanTo().setValue(set共通ポリシーパターン1(joho.get二次判定認定有効終了年月日()));
                        
            }
        } else if (SubGyomuCode.DBE認定支援.equals(subGyomuCode)) {
            List<ZenkaiNinteiKekkaJohoRelate> zenkaiNinteiKekkaJohoRelateList = getService().get要介護度_今回認定(shinseishoKanriNo).records();
            if (!zenkaiNinteiKekkaJohoRelateList.isEmpty()) {
                ZenkaiNinteiKekkaJohoRelate joho = zenkaiNinteiKekkaJohoRelateList.get(0);
                div.getTxtYokaigodo().setValue(set要介護度(joho.get厚労省IF識別コード(), new Code(joho.get二次判定要介護状態区分コード())));
                div.getTxtNinteiDay().setValue(set共通ポリシーパターン1(joho.get次判定年月日()));
                div.getTxtYukoKikanFrom().setValue(set共通ポリシーパターン1(joho.get二次判定認定有効開始年月日()));
                div.getTxtYukoKikanTo().setValue(set共通ポリシーパターン1(joho.get二次判定認定有効終了年月日()));
                        
            }
        }
    }
    
    private FlexibleDate set共通ポリシーパターン1(RString date) {
        if (date != null) {
            return new FlexibleDate(date);
        }
        return null;
    }
    
    private RString set要介護度(RString 厚労省IF識別コード, Code 前回要介護状態区分コード) {
        RString 要介護度 = RString.EMPTY;
        if (前回要介護状態区分コード != null) {
            if (new RString("99A").equals(厚労省IF識別コード)) {
                要介護度 = YokaigoJotaiKubun99.toValue(前回要介護状態区分コード.getColumnValue()).get名称();
            } else if (new RString("02A").equals(厚労省IF識別コード)) {
                要介護度 = YokaigoJotaiKubun02.toValue(前回要介護状態区分コード.getColumnValue()).get名称();
            } else if (new RString("99A").equals(厚労省IF識別コード)) {
                要介護度 = YokaigoJotaiKubun06.toValue(前回要介護状態区分コード.getColumnValue()).get名称();
            } else if (new RString("99A").equals(厚労省IF識別コード)) {
                要介護度 = YokaigoJotaiKubun09.toValue(前回要介護状態区分コード.getColumnValue()).get名称();
            } 
        }
        return 要介護度;
    }
    
    private ZenkaiNinteiKekkaJohoFinder getService() {
        return ZenkaiNinteiKekkaJohoFinder.createInstance();
    }
}
