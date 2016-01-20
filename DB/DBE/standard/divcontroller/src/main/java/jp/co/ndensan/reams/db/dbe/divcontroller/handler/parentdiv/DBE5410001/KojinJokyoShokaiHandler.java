/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5410001;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.core.kojinjokyoshokai.KojinJokyoShokai;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Shinsei.ShoriJotaiKubun;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5410001.KojinJokyoShokaiDiv;
import jp.co.ndensan.reams.db.dbe.entity.report.source.KojinShinchokuJokyohyo.KojinShinchokuJokyohyoEntity;
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.TokuteiShippei;
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.shinsei.NinteiShinseiHoreiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun09;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
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
     * 要介護認定個人状況のデータを設定します。
     *
     * @param kojinJokyoShokaiList 要介護認定個人状況
     */
    public void setKojinJokyoShokai(List<KojinJokyoShokai> kojinJokyoShokaiList) {
        div.getCcdKaigoNinteiAtenInfo();
        div.getCcdKaigoNinteiShikakuInfo();
        getKojinJokyoShokai1(kojinJokyoShokaiList);
        getKojinJokyoShokai2(kojinJokyoShokaiList);
    }
    
    private void getKojinJokyoShokai1(List<KojinJokyoShokai> kojinJokyoShokaiList) {
        if (kojinJokyoShokaiList.get(0).get認定調査依頼予定年月日() != null) {
        div.getTxtChosaIraiYoteiDate().setValue(new RDate(kojinJokyoShokaiList.get(0).get認定調査依頼予定年月日().toString()));
        }
        if (kojinJokyoShokaiList.get(0).get認定調査予定年月日() != null) {
        div.getTxtChosahyoNyushuYoteiDate().setValue(new RDate(
                kojinJokyoShokaiList.get(0).get認定調査予定年月日().toString()));
        }
        if (kojinJokyoShokaiList.get(0).get主治医意見書作成依頼予定年月日() != null) {
        div.getTxtIkenshoIraiYoteiDate().setValue(new RDate(
                kojinJokyoShokaiList.get(0).get主治医意見書作成依頼予定年月日().toString()));
        }
        if (kojinJokyoShokaiList.get(0).get主治医意見書登録予定年月日() != null) {
        div.getTxtIkenshoNyushuYoteiDate().setValue(new RDate(
                kojinJokyoShokaiList.get(0).get主治医意見書登録予定年月日().toString()));
        }
        if (kojinJokyoShokaiList.get(0).get要介護認定一次判定予定年月日() != null) {
        div.getTxtIchijiHanteiYoteiDate().setValue(new RDate(
                kojinJokyoShokaiList.get(0).get要介護認定一次判定予定年月日().toString()));
        }
        div.getTxtMaskingYoteiDate().setValue(null);
        if (kojinJokyoShokaiList.get(0).get認定審査会割当予定年月日() != null) {
        div.getTxtShinsakaiTorokuYoteiDate().setValue(new RDate(
                kojinJokyoShokaiList.get(0).get認定審査会割当予定年月日().toString()));
        }
        if (kojinJokyoShokaiList.get(0).get認定審査会予定年月日() != null) {
        div.getTxtNijiHanteiYoteiDate().setValue(new RDate(
                kojinJokyoShokaiList.get(0).get認定審査会予定年月日().toString()));
        }
        if (kojinJokyoShokaiList.get(0).get認定調査依頼完了年月日() != null) {
        div.getTxtChosaIraiJissekiDate().setValue(new RDate(
                kojinJokyoShokaiList.get(0).get認定調査依頼完了年月日().toString()));
        }
        if (kojinJokyoShokaiList.get(0).get認定調査完了年月日() != null) {
        div.getTxtChosahyoNyushuJissekiDate().setValue(new RDate(
                kojinJokyoShokaiList.get(0).get認定調査完了年月日().toString()));
        }
        if (kojinJokyoShokaiList.get(0).get主治医意見書作成依頼完了年月日() != null) {
        div.getTxtIkenshoIraiJissekiDate().setValue(new RDate(
                kojinJokyoShokaiList.get(0).get主治医意見書作成依頼完了年月日().toString()));
        }
        if (kojinJokyoShokaiList.get(0).get主治医意見書登録完了年月日() != null) {
        div.getTxtIkenshoNyushuJissekiDate().setValue(new RDate(
                kojinJokyoShokaiList.get(0).get主治医意見書登録完了年月日().toString()));
        }
        if (kojinJokyoShokaiList.get(0).get要介護認定一次判定完了年月日() != null) {
        div.getTxtIchijiHanteiJissekiDate().setValue(new RDate(
                kojinJokyoShokaiList.get(0).get要介護認定一次判定完了年月日().toString()));
        }
        if (kojinJokyoShokaiList.get(0).getマスキング完了年月日() != null) {
        div.getTxtMaskingJissekiDate().setValue(new RDate(
                kojinJokyoShokaiList.get(0).getマスキング完了年月日().toString()));
        }
        if (kojinJokyoShokaiList.get(0).get認定審査会割当完了年月日() != null) {
        div.getTxtShinsakaiTorokuJissekiDate().setValue(new RDate(
                kojinJokyoShokaiList.get(0).get認定審査会割当完了年月日().toString()));
        }
        if (kojinJokyoShokaiList.get(0).get認定審査会完了年月日() != null) {
        div.getTxtNijiHanteiJissekiDate().setValue(new RDate(
                kojinJokyoShokaiList.get(0).get認定審査会完了年月日().toString()));
        }
        if (kojinJokyoShokaiList.get(0).get認定申請年月日() != null) {
        div.getTxtNinteiShinseiDay().setValue(new RDate(
                kojinJokyoShokaiList.get(0).get認定申請年月日().toString()));
        }
    }
    
    private void getKojinJokyoShokai2(List<KojinJokyoShokai> kojinJokyoShokaiList) {
        
        if (kojinJokyoShokaiList.get(0).get認定申請区分申請時() != null) {
        div.getTxtShinseiKubunShinseiji().setValue(NinteiShinseiShinseijiKubunCode.
                toValue(new RString(kojinJokyoShokaiList.get(0).get認定申請区分申請時().toString())).toRString());
        }
        if (kojinJokyoShokaiList.get(0).get認定申請区分法令時() != null) {
        div.getTxtShinseiKubunHorei().setValue(NinteiShinseiHoreiCode.
                toValue(new RString(kojinJokyoShokaiList.get(0).get認定申請区分法令時().toString())).toRString());
        }
        if (kojinJokyoShokaiList.get(0).get二次判定要介護状態区分コード() != null) {
        div.getTxtNinteiKekka().setValue(YokaigoJotaiKubun09.
                toValue(new RString(kojinJokyoShokaiList.get(0).get二次判定要介護状態区分コード().toString())).get名称());
        }
        if (kojinJokyoShokaiList.get(0).get二次判定認定有効開始年月日() != null) {
        div.getTxtNinteiYukoKikanFrom().setValue(new RDate(
                kojinJokyoShokaiList.get(0).get二次判定認定有効開始年月日().toString()));
        }
        if (kojinJokyoShokaiList.get(0).get二次判定認定有効終了年月日() != null) {
        div.getTxtNinteiYukoKikanTo().setValue(new RDate(
                kojinJokyoShokaiList.get(0).get二次判定認定有効終了年月日().toString()));
        }
        div.getTxtNinteiKikanMonth().setValue(new Decimal(kojinJokyoShokaiList.get(0).get二次判定認定有効期間()));
        // TODO 蘇広俊 QA518提出中
//        if (kojinJokyoShokaiList.get(0).get要支援申請の区分() != null) {
//         div.getTxtShinseiShubetsu().setValue(ShienShinseiKubun.
//                toValue(new RString(kojinJokyoShokaiList.get(0).get要支援申請の区分().toString())).get名称());
//        }
        if (kojinJokyoShokaiList.get(0).get二号特定疾病コード() != null) {
         div.getTxtTokuteiShippei().setValue(TokuteiShippei.
                toValue(new RString(kojinJokyoShokaiList.get(0).get二号特定疾病コード().toString())).toRString());
        }
        // TODO 蘇広俊 QA518提出中
//        div.getTxtJohoTeikyoDoi().setValue(IsExistJohoTeikyoDoui.
//                toValue(kojinJokyoShokaiList.get(0).get情報提供への同意有無()).get名称());
//        if (kojinJokyoShokaiList.get(0).get要介護認定一次判定結果コード() != null) {
//        div.getTxtIchijiHantei().setValue(IchijiHanteiKekkaCode09.
//                toValue(new RString(kojinJokyoShokaiList.get(0).get要介護認定一次判定結果コード().toString())).get名称());
//        }
        if (kojinJokyoShokaiList.get(0).get審査会開催年月日() != null) {
        div.getTxtKaisaiDay().setValue(new RDate(
                kojinJokyoShokaiList.get(0).get審査会開催年月日().toString()));
        }
        if (kojinJokyoShokaiList.get(0).get処理状態区分() != null) {
        div.getTxtShoriKubun().setValue(ShoriJotaiKubun.
                toValue(new RString(kojinJokyoShokaiList.get(0).get処理状態区分().toString())).get名称());
        }
    }
    
    /**
     *要介護認定個人状況のデータを設定します。
     *
     * @param kojinJokyoShokaiList 要介護認定個人状況
     * @return KojinShinchokuJokyohyoEntity
     */
    public KojinShinchokuJokyohyoEntity setKojinShinchokuJokyohyo(List<KojinJokyoShokai> kojinJokyoShokaiList) {
        KojinShinchokuJokyohyoEntity jokyohyoEntity = getKojinShinchokuJokyohyo(kojinJokyoShokaiList);
        
        return jokyohyoEntity;
    }
    
    private KojinShinchokuJokyohyoEntity getKojinShinchokuJokyohyo(List<KojinJokyoShokai> kojinJokyoShokaiList) {
        requireNonNull(kojinJokyoShokaiList, UrSystemErrorMessages.値がnull.getReplacedMessage("kojinJokyoShokaiList"));
        KojinShinchokuJokyohyoEntity jokyohyoEntity = new KojinShinchokuJokyohyoEntity();
        jokyohyoEntity.setHihokenshaNo(kojinJokyoShokaiList.get(0).get被保険者番号().getColumnValue());
        jokyohyoEntity.setShinseiKubun(kojinJokyoShokaiList.get(0).get認定申請区分申請時コード().getColumnValue());
        jokyohyoEntity.setHihokenshaNameKana(kojinJokyoShokaiList.get(0).get被保険者氏名カナ());
        jokyohyoEntity.setShinseiYMD(new RString(kojinJokyoShokaiList.get(0).get認定申請年月日().toString()));
        jokyohyoEntity.setSeibetsu(kojinJokyoShokaiList.get(0).get性別());
        jokyohyoEntity.setHihokenshaName(kojinJokyoShokaiList.get(0).get被保険者氏名());
        jokyohyoEntity.setBirthYMD(new RString(kojinJokyoShokaiList.get(0).get生年月日().toString()));
        jokyohyoEntity.setAge(new RString(String.valueOf(kojinJokyoShokaiList.get(0).get年齢())));
        jokyohyoEntity.setYubinNo1(new RString(kojinJokyoShokaiList.get(0).get郵便番号().toString()));
        jokyohyoEntity.setHihokenshaJusho(new RString(kojinJokyoShokaiList.get(0).get住所().toString()));
        jokyohyoEntity.setTelNo1(new RString(kojinJokyoShokaiList.get(0).get電話番号().toString()));
        jokyohyoEntity.setShinseiRiyu(kojinJokyoShokaiList.get(0).get認定申請理由());
        jokyohyoEntity.setShinseishaName(kojinJokyoShokaiList.get(0).get申請者氏名());
        jokyohyoEntity.setShinseiDaikoJigyoshaName(kojinJokyoShokaiList.get(0).get申請代行事業者());
        jokyohyoEntity.setShinseishaKankei(kojinJokyoShokaiList.get(0).get申請届出代行区分コード().getColumnValue());
        jokyohyoEntity.setHonninKankei(kojinJokyoShokaiList.get(0).get申請届出者続柄コード().getColumnValue());
        jokyohyoEntity.setYubinNo2(kojinJokyoShokaiList.get(0).get申請者郵便番号().getColumnValue());
        jokyohyoEntity.setShinseishaJusho(kojinJokyoShokaiList.get(0).get申請届出者住所().getColumnValue());
        jokyohyoEntity.setTelNo2(kojinJokyoShokaiList.get(0).get申請届出者電話番号().getColumnValue());
        jokyohyoEntity.setShisetsuName(kojinJokyoShokaiList.get(0).get入所施設名());
        jokyohyoEntity.setShisetsujusho(kojinJokyoShokaiList.get(0).get入所施設所在地().getColumnValue());
        jokyohyoEntity.setTelNo3(kojinJokyoShokaiList.get(0).get入所施設電話番号().getColumnValue());
        jokyohyoEntity.setChosain_1(kojinJokyoShokaiList.get(0).get今回事業者名称());
        jokyohyoEntity.setChosain_2(kojinJokyoShokaiList.get(0).get今回調査員氏名());
        jokyohyoEntity.setChosain_3(kojinJokyoShokaiList.get(0).get今回調査員電話番号().getColumnValue());
        jokyohyoEntity.setChosain_4(kojinJokyoShokaiList.get(0).get前回事業者名称());
        jokyohyoEntity.setChosain_5(kojinJokyoShokaiList.get(0).get前回調査員氏名());
        jokyohyoEntity.setChosain_6(kojinJokyoShokaiList.get(0).get前回調査員電話番号().getColumnValue());
        jokyohyoEntity.setChosain_7(kojinJokyoShokaiList.get(0).get前々回事業者名称());
        jokyohyoEntity.setChosain_8(kojinJokyoShokaiList.get(0).get前々回調査員氏名());
        jokyohyoEntity.setChosain_9(kojinJokyoShokaiList.get(0).get前々回調査員電話番号().getColumnValue());
        jokyohyoEntity.setShui_1(kojinJokyoShokaiList.get(0).get今回医療機関名称());
        jokyohyoEntity.setShui_2(kojinJokyoShokaiList.get(0).get今回主治医名());
        jokyohyoEntity.setShui_3(kojinJokyoShokaiList.get(0).get今回主治医電話番号().getColumnValue());
        jokyohyoEntity.setShui_4(kojinJokyoShokaiList.get(0).get前回医療機関名称());
        jokyohyoEntity.setShui_5(kojinJokyoShokaiList.get(0).get前回主治医名());
        jokyohyoEntity.setShui_6(kojinJokyoShokaiList.get(0).get前回主治医電話番号().getColumnValue());
        jokyohyoEntity.setShui_7(kojinJokyoShokaiList.get(0).get前々回医療機関名称());
        jokyohyoEntity.setShui_8(kojinJokyoShokaiList.get(0).get前々回主治医名());
        jokyohyoEntity.setShui_9(kojinJokyoShokaiList.get(0).get前々回主治医電話番号().getColumnValue());
        jokyohyoEntity.setKonnkai_1(new RString(kojinJokyoShokaiList.get(0).get今回申請情報登録完了年月日().toString()));
        jokyohyoEntity.setZennkai_1(new RString(kojinJokyoShokaiList.get(0).get前回申請情報登録完了年月日().toString()));
        jokyohyoEntity.setZennnoma_1(new RString(kojinJokyoShokaiList.get(0).get前々回申請情報登録完了年月日().toString()));
        jokyohyoEntity.setKonnkai_2(new RString(kojinJokyoShokaiList.get(0).get今回認定調査依頼予定年月日().toString()));
        jokyohyoEntity.setZennkai_2(new RString(kojinJokyoShokaiList.get(0).get前回認定調査依頼予定年月日().toString()));
        jokyohyoEntity.setZennnoma_2(new RString(kojinJokyoShokaiList.get(0).get前々回認定調査依頼予定年月日().toString()));
        jokyohyoEntity.setKonnkai_3(new RString(kojinJokyoShokaiList.get(0).get今回認定調査依頼年月日().toString()));
        jokyohyoEntity.setZennkai_3(new RString(kojinJokyoShokaiList.get(0).get前回認定調査依頼年月日().toString()));
        jokyohyoEntity.setZennnoma_3(new RString(kojinJokyoShokaiList.get(0).get前々回認定調査依頼年月日().toString()));
        jokyohyoEntity.setKonnkai_4(new RString(kojinJokyoShokaiList.get(0).get今回調査依頼完了年月日().toString()));
        jokyohyoEntity.setZennkai_4(new RString(kojinJokyoShokaiList.get(0).get前回調査依頼完了年月日().toString()));
        jokyohyoEntity.setZennnoma_4(new RString(kojinJokyoShokaiList.get(0).get前々回調査依頼完了年月日().toString()));
        jokyohyoEntity.setKonnkai_5(new RString(kojinJokyoShokaiList.get(0).get今回認定調査予定年月日().toString()));
        jokyohyoEntity.setZennkai_5(new RString(kojinJokyoShokaiList.get(0).get前回認定調査予定年月日().toString()));
        jokyohyoEntity.setZennnoma_5(new RString(kojinJokyoShokaiList.get(0).get前々回認定調査予定年月日().toString()));
        jokyohyoEntity.setKonnkai_6(new RString(kojinJokyoShokaiList.get(0).get今回認定調査受領年月日().toString()));
        jokyohyoEntity.setZennkai_6(new RString(kojinJokyoShokaiList.get(0).get前回認定調査受領年月日().toString()));
        jokyohyoEntity.setZennnoma_6(new RString(kojinJokyoShokaiList.get(0).get前々回認定調査受領年月日().toString()));
        jokyohyoEntity.setKonnkai_7(new RString(kojinJokyoShokaiList.get(0).get今回調査完了年月日().toString()));
        jokyohyoEntity.setZennkai_7(new RString(kojinJokyoShokaiList.get(0).get前回調査完了年月日().toString()));
        jokyohyoEntity.setZennnoma_7(new RString(kojinJokyoShokaiList.get(0).get前々調査完了年月日().toString()));
        jokyohyoEntity.setKonnkai_8(new RString(kojinJokyoShokaiList.get(0).get今回主治医意見書作成依頼予定年月日().toString()));
        jokyohyoEntity.setZennkai_8(new RString(kojinJokyoShokaiList.get(0).get前回主治医意見書作成依頼予定年月日().toString()));
        jokyohyoEntity.setZennnoma_8(new RString(kojinJokyoShokaiList.get(0).get前々回主治医意見書作成依頼予定年月日().toString()));
        jokyohyoEntity.setKonnkai_9(new RString(kojinJokyoShokaiList.get(0).get今回主治医意見書作成依頼年月日().toString()));
        jokyohyoEntity.setZennkai_9(new RString(kojinJokyoShokaiList.get(0).get前回主治医意見書作成依頼年月日().toString()));
        jokyohyoEntity.setZennnoma_9(new RString(kojinJokyoShokaiList.get(0).get前々回主治医意見書作成依頼年月日().toString()));
        jokyohyoEntity.setKonnkai_10(new RString(kojinJokyoShokaiList.get(0).get今回意見書作成依頼完了年月日().toString()));
        jokyohyoEntity.setZennkai_10(new RString(kojinJokyoShokaiList.get(0).get前回意見書作成依頼完了年月日().toString()));
        jokyohyoEntity.setZennnoma_10(new RString(kojinJokyoShokaiList.get(0).get前々回意見書作成依頼完了年月日().toString()));
        jokyohyoEntity.setKonnkai_11(new RString(kojinJokyoShokaiList.get(0).get今回主治医意見書登録予定年月日().toString()));
        jokyohyoEntity.setZennkai_11(new RString(kojinJokyoShokaiList.get(0).get前回主治医意見書登録予定年月日().toString()));
        jokyohyoEntity.setZennnoma_11(new RString(kojinJokyoShokaiList.get(0).get前々回主治医意見書登録予定年月日().toString()));
        jokyohyoEntity.setKonnkai_12(new RString(kojinJokyoShokaiList.get(0).get今回主治医意見書受領年月日().toString()));
        jokyohyoEntity.setZennkai_12(new RString(kojinJokyoShokaiList.get(0).get前回主治医意見書受領年月日().toString()));
        jokyohyoEntity.setZennnoma_12(new RString(kojinJokyoShokaiList.get(0).get前々回主治医意見書受領年月日().toString()));
        jokyohyoEntity.setKonnkai_13(new RString(kojinJokyoShokaiList.get(0).get今回意見書登録完了年月日().toString()));
        jokyohyoEntity.setZennkai_13(new RString(kojinJokyoShokaiList.get(0).get前回意見書登録完了年月日().toString()));
        jokyohyoEntity.setZennnoma_13(new RString(kojinJokyoShokaiList.get(0).get前々回意見書登録完了年月日().toString()));
        jokyohyoEntity.setKonnkai_14(new RString(kojinJokyoShokaiList.get(0).get今回要介護認定一次判定予定年月日().toString()));
        jokyohyoEntity.setZennkai_14(new RString(kojinJokyoShokaiList.get(0).get前回要介護認定一次判定予定年月日().toString()));
        jokyohyoEntity.setZennnoma_14(new RString(kojinJokyoShokaiList.get(0).get前々回要介護認定一次判定予定年月日().toString()));
        jokyohyoEntity.setKonnkai_15(new RString(kojinJokyoShokaiList.get(0).get今回一次判定完了年月日().toString()));
        jokyohyoEntity.setZennkai_15(new RString(kojinJokyoShokaiList.get(0).get前回一次判定完了年月日().toString()));
        jokyohyoEntity.setZennnoma_15(new RString(kojinJokyoShokaiList.get(0).get前々回一次判定完了年月日().toString()));
        jokyohyoEntity.setKonnkai_16(new RString(kojinJokyoShokaiList.get(0).get今回マスキング完了年月日().toString()));
        jokyohyoEntity.setZennkai_16(new RString(kojinJokyoShokaiList.get(0).get前回マスキング完了年月日().toString()));
        jokyohyoEntity.setZennnoma_16(new RString(kojinJokyoShokaiList.get(0).get前々回マスキング完了年月日().toString()));
        jokyohyoEntity.setKonnkai_17(new RString(kojinJokyoShokaiList.get(0).get今回認定審査会割当予定年月日().toString()));
        jokyohyoEntity.setZennkai_17(new RString(kojinJokyoShokaiList.get(0).get前回認定審査会割当予定年月日().toString()));
        jokyohyoEntity.setZennnoma_17(new RString(kojinJokyoShokaiList.get(0).get前々回認定審査会割当予定年月日().toString()));
        jokyohyoEntity.setKonnkai_18(new RString(kojinJokyoShokaiList.get(0).get今回認定審査会予定年月日().toString()));
        jokyohyoEntity.setZennkai_18(new RString(kojinJokyoShokaiList.get(0).get前回認定審査会予定年月日().toString()));
        jokyohyoEntity.setZennnoma_18(new RString(kojinJokyoShokaiList.get(0).get前々回認定審査会予定年月日().toString()));
        jokyohyoEntity.setKonnkai_19(new RString(kojinJokyoShokaiList.get(0).get今回審査会割当完了年月日().toString()));
        jokyohyoEntity.setZennkai_19(new RString(kojinJokyoShokaiList.get(0).get前回審査会割当完了年月日().toString()));
        jokyohyoEntity.setZennnoma_19(new RString(kojinJokyoShokaiList.get(0).get前々回審査会割当完了年月日().toString()));
        jokyohyoEntity.setKonnkai_20(new RString(kojinJokyoShokaiList.get(0).get今回審査会割当完了年月日().toString()));
        jokyohyoEntity.setZennkai_20(new RString(kojinJokyoShokaiList.get(0).get前回審査会完了年月日().toString()));
        jokyohyoEntity.setZennnoma_20(new RString(kojinJokyoShokaiList.get(0).get前々回審査会完了年月日().toString()));
        jokyohyoEntity.setKonnkai_21(new RString(kojinJokyoShokaiList.get(0).get今回センター送信予定年月日().toString()));
        jokyohyoEntity.setZennkai_21(new RString(kojinJokyoShokaiList.get(0).get前回センター送信予定年月日().toString()));
        jokyohyoEntity.setZennnoma_21(new RString(kojinJokyoShokaiList.get(0).get前々回センター送信予定年月日().toString()));
        jokyohyoEntity.setKonnkai_22(new RString(kojinJokyoShokaiList.get(0).get今回センター送信年月日().toString()));
        jokyohyoEntity.setZennkai_22(new RString(kojinJokyoShokaiList.get(0).get前回センター送信年月日().toString()));
        jokyohyoEntity.setZennnoma_22(new RString(kojinJokyoShokaiList.get(0).get前々回センター送信年月日().toString()));
        
        return jokyohyoEntity;
    }
}
