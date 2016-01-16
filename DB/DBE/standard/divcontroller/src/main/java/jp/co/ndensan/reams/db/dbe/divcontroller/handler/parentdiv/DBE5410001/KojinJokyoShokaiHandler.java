/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5410001;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.enumeratedtype.core.IchijiHanteiKekkaCode09;
import jp.co.ndensan.reams.db.dbd.definition.enumeratedtype.core.IsExistJohoTeikyoDoui;
import jp.co.ndensan.reams.db.dbd.definition.enumeratedtype.core.NinteiShinseiHoreiCode;
import jp.co.ndensan.reams.db.dbd.definition.enumeratedtype.core.ShienShinseiKubun;
import jp.co.ndensan.reams.db.dbe.business.core.kojinjokyoshokai.KojinJokyoShokai;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Shinsei.ShoriJotaiKubun;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5410001.KojinJokyoShokaiDiv;
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.TokuteiShippei;

import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun09;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 要介護認定個人状況照会のハンドラークラスです。
 */
public class KojinJokyoShokaiHandler {
    
     private final KojinJokyoShokaiDiv div;
    
     /**
     * コンストラクタです。
     *
     * @param div 要介護認定個人状況照会div
     */
    public KojinJokyoShokaiHandler(KojinJokyoShokaiDiv div) {
        this.div = div;
    }
    
    /**
     *要介護認定個人状況のデータを設定します。
     *
     * @param kojinJokyoShokaiList
     */
    public void setkojinJokyoShokai(List<KojinJokyoShokai> kojinJokyoShokaiList) {
        div.getCcdKaigoNinteiAtenInfo();
        div.getCcdKaigoNinteiShikakuInfo();
        if(kojinJokyoShokaiList.get(0).get認定調査依頼予定年月日() != null){
        div.getTxtChosaIraiYoteiDate().setValue(new RDate(kojinJokyoShokaiList.get(0).get認定調査依頼予定年月日().toString()));
        }
        if(kojinJokyoShokaiList.get(0).get認定調査予定年月日() != null){
        div.getTxtChosahyoNyushuYoteiDate().setValue(new RDate(
                kojinJokyoShokaiList.get(0).get認定調査予定年月日().toString()));
        }
        if(kojinJokyoShokaiList.get(0).get主治医意見書作成依頼予定年月日() != null){
        div.getTxtIkenshoIraiYoteiDate().setValue(new RDate(
                kojinJokyoShokaiList.get(0).get主治医意見書作成依頼予定年月日().toString()));
        }
        if(kojinJokyoShokaiList.get(0).get主治医意見書登録予定年月日() != null){
        div.getTxtIkenshoNyushuYoteiDate().setValue(new RDate(
                kojinJokyoShokaiList.get(0).get主治医意見書登録予定年月日().toString()));
        }
        if(kojinJokyoShokaiList.get(0).get要介護認定一次判定予定年月日() != null){
        div.getTxtIchijiHanteiYoteiDate().setValue(new RDate(
                kojinJokyoShokaiList.get(0).get要介護認定一次判定予定年月日().toString()));
        }
        div.getTxtMaskingYoteiDate().setValue(null);
        if(kojinJokyoShokaiList.get(0).get認定審査会割当予定年月日() != null){
        div.getTxtShinsakaiTorokuYoteiDate().setValue(new RDate(
                kojinJokyoShokaiList.get(0).get認定審査会割当予定年月日().toString()));
        }
        if(kojinJokyoShokaiList.get(0).get認定審査会予定年月日() != null){
        div.getTxtNijiHanteiYoteiDate().setValue(new RDate(
                kojinJokyoShokaiList.get(0).get認定審査会予定年月日().toString()));
        }
        if(kojinJokyoShokaiList.get(0).get認定調査依頼完了年月日() != null){
        div.getTxtChosaIraiJissekiDate().setValue(new RDate(
                kojinJokyoShokaiList.get(0).get認定調査依頼完了年月日().toString()));
        }
        if(kojinJokyoShokaiList.get(0).get認定調査完了年月日() != null){
        div.getTxtChosahyoNyushuJissekiDate().setValue(new RDate(
                kojinJokyoShokaiList.get(0).get認定調査完了年月日().toString()));
        }
        if(kojinJokyoShokaiList.get(0).get主治医意見書作成依頼完了年月日() != null){
        div.getTxtIkenshoIraiJissekiDate().setValue(new RDate(
                kojinJokyoShokaiList.get(0).get主治医意見書作成依頼完了年月日().toString()));
        }
        if(kojinJokyoShokaiList.get(0).get主治医意見書登録完了年月日() != null){
        div.getTxtIkenshoNyushuJissekiDate().setValue(new RDate(
                kojinJokyoShokaiList.get(0).get主治医意見書登録完了年月日().toString()));
        }
        if(kojinJokyoShokaiList.get(0).get要介護認定一次判定完了年月日() != null){
        div.getTxtIchijiHanteiJissekiDate().setValue(new RDate(
                kojinJokyoShokaiList.get(0).get要介護認定一次判定完了年月日().toString()));
        }
        if(kojinJokyoShokaiList.get(0).getマスキング完了年月日() != null){
        div.getTxtMaskingJissekiDate().setValue(new RDate(
                kojinJokyoShokaiList.get(0).getマスキング完了年月日().toString()));
        }
        if(kojinJokyoShokaiList.get(0).get認定審査会割当完了年月日() != null){
        div.getTxtShinsakaiTorokuJissekiDate().setValue(new RDate(
                kojinJokyoShokaiList.get(0).get認定審査会割当完了年月日().toString()));
        }
        if(kojinJokyoShokaiList.get(0).get認定審査会完了年月日() != null){
        div.getTxtNijiHanteiJissekiDate().setValue(new RDate(
                kojinJokyoShokaiList.get(0).get認定審査会完了年月日().toString()));
        }
        if(kojinJokyoShokaiList.get(0).get認定申請年月日() != null){
        div.getTxtNinteiShinseiDay().setValue(new RDate(
                kojinJokyoShokaiList.get(0).get認定申請年月日().toString()));
        }
        if(kojinJokyoShokaiList.get(0).get認定申請区分申請時() != null){
        div.getTxtShinseiKubunShinseiji().setValue(NinteiShinseiShinseijiKubunCode.
                toValue(new RString(kojinJokyoShokaiList.get(0).get認定申請区分申請時().toString())).toRString());
        }
        if(kojinJokyoShokaiList.get(0).get認定申請区分法令時() != null){
        div.getTxtShinseiKubunHorei().setValue(NinteiShinseiHoreiCode.
                toValue(new RString(kojinJokyoShokaiList.get(0).get認定申請区分法令時().toString())).get名称());
        }
        if(kojinJokyoShokaiList.get(0).get二次判定要介護状態区分コード() != null){
        div.getTxtNinteiKekka().setValue(YokaigoJotaiKubun09.
                toValue(new RString(kojinJokyoShokaiList.get(0).get二次判定要介護状態区分コード().toString())).get名称());
        }
        if(kojinJokyoShokaiList.get(0).get二次判定認定有効開始年月日() != null){
        div.getTxtNinteiYukoKikanFrom().setValue(new RDate(
                kojinJokyoShokaiList.get(0).get二次判定認定有効開始年月日().toString()));
        }
        if(kojinJokyoShokaiList.get(0).get二次判定認定有効終了年月日() != null){
        div.getTxtNinteiYukoKikanTo().setValue(new RDate(
                kojinJokyoShokaiList.get(0).get二次判定認定有効終了年月日().toString()));
        }
        div.getTxtNinteiKikanMonth().setValue(new Decimal(kojinJokyoShokaiList.get(0).get二次判定認定有効期間()));
        if(kojinJokyoShokaiList.get(0).get要支援申請の区分() != null){
         div.getTxtShinseiShubetsu().setValue(ShienShinseiKubun.
                toValue(new RString(kojinJokyoShokaiList.get(0).get要支援申請の区分().toString())).get名称());
        }
        if(kojinJokyoShokaiList.get(0).get二号特定疾病コード() != null){
         div.getTxtTokuteiShippei().setValue(TokuteiShippei.
                toValue(new RString(kojinJokyoShokaiList.get(0).get二号特定疾病コード().toString())).toRString());
        }
        div.getTxtJohoTeikyoDoi().setValue(IsExistJohoTeikyoDoui.
                toValue(kojinJokyoShokaiList.get(0).get情報提供への同意有無()).get名称());
        if(kojinJokyoShokaiList.get(0).get要介護認定一次判定結果コード() != null){
        div.getTxtIchijiHantei().setValue(IchijiHanteiKekkaCode09.
                toValue(new RString(kojinJokyoShokaiList.get(0).get要介護認定一次判定結果コード().toString())).get名称());
        }
        if(kojinJokyoShokaiList.get(0).get審査会開催年月日() != null){
        div.getTxtKaisaiDay().setValue(new RDate(
                kojinJokyoShokaiList.get(0).get審査会開催年月日().toString()));
        }
        if(kojinJokyoShokaiList.get(0).get処理状態区分() != null){
        div.getTxtShoriKubun().setValue(ShoriJotaiKubun.
                toValue(new RString(kojinJokyoShokaiList.get(0).get処理状態区分().toString())).get名称());
        }
    }
}
