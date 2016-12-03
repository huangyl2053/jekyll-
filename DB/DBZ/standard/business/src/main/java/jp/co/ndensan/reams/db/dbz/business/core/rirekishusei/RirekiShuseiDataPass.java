/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.rirekishusei;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.util.ObjectUtil;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.business.core.ninteichosajokyo.NinteiChosaJokyoDataPass;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.SystemException;

/**
 * 履歴修正用のビジネスクラスです
 *
 * @reamsid_L DBZ-1330-030 chengsanyuan
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class RirekiShuseiDataPass implements Serializable, Cloneable {

    private static final long serialVersionUID = 2502561546047444606L;

    private Code データ区分;
    private FlexibleDate 認定年月日;
    private Code 要介護状態区分コード;
    private FlexibleDate 認定有効開始年月日;
    private FlexibleDate 認定有効終了年月日;
    private boolean 旧措置フラグ;
    private RString 介護認定審査会意見;
    private RString 要介護申請_要支援申請の区分;
    private FlexibleDate 認定申請年月日;
    private Code 認定申請区分_法令_コード;
    private Code 認定申請区分_申請時_コード;
    private RString 被保険者区分コード;
    private Code 二号特定疾病コード;
    private RString 支所コード;
    private RString 認定申請理由;
    private FlexibleDate 取下年月日;
    private Code 受給申請事由;
    private RString 申請状況区分;
    private boolean 資格取得前申請フラグ;
    private Code みなし要介護区分コード;
    private ServiceShuruiCode 指定サービス種類01;
    private ServiceShuruiCode 指定サービス種類02;
    private ServiceShuruiCode 指定サービス種類03;
    private ServiceShuruiCode 指定サービス種類04;
    private ServiceShuruiCode 指定サービス種類05;
    private ServiceShuruiCode 指定サービス種類06;
    private ServiceShuruiCode 指定サービス種類07;
    private ServiceShuruiCode 指定サービス種類08;
    private ServiceShuruiCode 指定サービス種類09;
    private ServiceShuruiCode 指定サービス種類10;
    private ServiceShuruiCode 指定サービス種類11;
    private ServiceShuruiCode 指定サービス種類12;
    private ServiceShuruiCode 指定サービス種類13;
    private ServiceShuruiCode 指定サービス種類14;
    private ServiceShuruiCode 指定サービス種類15;
    private ServiceShuruiCode 指定サービス種類16;
    private ServiceShuruiCode 指定サービス種類17;
    private ServiceShuruiCode 指定サービス種類18;
    private ServiceShuruiCode 指定サービス種類19;
    private ServiceShuruiCode 指定サービス種類20;
    private ServiceShuruiCode 指定サービス種類21;
    private ServiceShuruiCode 指定サービス種類22;
    private ServiceShuruiCode 指定サービス種類23;
    private ServiceShuruiCode 指定サービス種類24;
    private ServiceShuruiCode 指定サービス種類25;
    private ServiceShuruiCode 指定サービス種類26;
    private ServiceShuruiCode 指定サービス種類27;
    private ServiceShuruiCode 指定サービス種類28;
    private ServiceShuruiCode 指定サービス種類29;
    private ServiceShuruiCode 指定サービス種類30;
    private Code 削除事由コード;
    private RString 異動理由;
    private FlexibleDate 喪失年月日;
    private FlexibleDate 当初認定有効開始年月日;
    private FlexibleDate 当初認定有効終了年月日;
    private FlexibleDate 受給資格証明書発行年月日１;
    private FlexibleDate 受給資格証明書発行年月日２;
    private Code 届出代行区分;
    private RString 氏名;
    private RString カナ氏名;
    private RString 本人との関係性;
    private JigyoshaNo 事業者番号;
    private RString 事業者区分;
    private YubinNo 郵便番号;
    private RString 住所;
    private TelNo 電話番号;
    private Code 前回要介護状態区分コード;
    private FlexibleDate 前回認定年月日;
    private FlexibleDate 前回認定有効開始年月日;
    private FlexibleDate 前回認定有効終了年月日;
    private RString 調査員への連絡事項;
    private RString 主治医への連絡事項;

    private RString 認定調査員コード;
    private RString 調査員氏名;
    private RString 認定調査委託先コード;
    private RString 事業者名称;
    private YubinNo 認定郵便番号;
    private RString 認定住所;
    private TelNo 認定電話番号;
    private FlexibleDate 認定調査依頼年月日;
    private FlexibleDate 認定調査予定年月日;
    private FlexibleDate 認定調査実施年月日;
    private RString 調査委託区分;
    private AtenaMeisho 訪問調査先名称;
    private YubinNo 訪問調査先郵便番号;
    private AtenaJusho 訪問調査先住所;
    private TelNo 訪問調査先電話番号;
    private RString 主治医コード;
    private RString 主治医氏名;
    private RString 主治医医療機関コード;
    private RString 医療機関名称;
    private YubinNo 主治医郵便番号;
    private RString 主治医住所;
    private TelNo 主治医電話番号;
    private FlexibleDate 主治医意見書作成依頼年月日;
    private FlexibleDate 主治医意見書登録予定年月日;
    private FlexibleDate 主治医意見書記入年月日;
    private boolean 指定医フラグ;
    private Code 要介護認定一次判定結果コード;
    private FlexibleDate 要介護認定一次判定年月日;
    private Code 要介護認定一次判定結果コード_認知症加算;
    private RDate 介護認定審査会資料作成年月日;
    private RDate 認定審査会予定年月日;
    private RDate 二次判定年月日;
    private Code 二次判定要介護状態区分コード;
    private int 二次判定認定有効期間;
    private FlexibleDate 二次判定認定有効開始年月日;
    private FlexibleDate 二次判定認定有効終了年月日;
    private RDate 延期通知発行年月日;
    private int 延期通知発行回数;
    private ShinseishoKanriNo 申請書管理番号;
    private LasdecCode 市町村コード;
    private Code 厚労省IF識別コード;

    /**
     * 調査状況用のデータを取得
     *
     * @return NinteiChosaJokyoDataPass 調査状況
     */
    public NinteiChosaJokyoDataPass get調査状況用情報() {
        NinteiChosaJokyoDataPass dataPass = new NinteiChosaJokyoDataPass();
        dataPass.set認定調査員コード(ObjectUtil.defaultIfNull(認定調査員コード, RString.EMPTY));
        dataPass.set調査員氏名(ObjectUtil.defaultIfNull(調査員氏名, RString.EMPTY));
        dataPass.set認定調査委託先コード(ObjectUtil.defaultIfNull(認定調査委託先コード, RString.EMPTY));
        dataPass.set事業者名称(ObjectUtil.defaultIfNull(事業者名称, RString.EMPTY));
        dataPass.set認定郵便番号(ObjectUtil.defaultIfNull(認定郵便番号, YubinNo.EMPTY));
        dataPass.set認定住所(ObjectUtil.defaultIfNull(認定住所, RString.EMPTY));
        dataPass.set認定電話番号(ObjectUtil.defaultIfNull(認定電話番号, TelNo.EMPTY));
        dataPass.set認定調査依頼年月日(ObjectUtil.defaultIfNull(認定調査依頼年月日, FlexibleDate.EMPTY));
        dataPass.set認定調査予定年月日(ObjectUtil.defaultIfNull(認定調査予定年月日, FlexibleDate.EMPTY));
        dataPass.set認定調査実施年月日(ObjectUtil.defaultIfNull(認定調査実施年月日, FlexibleDate.EMPTY));
        dataPass.set調査委託区分(ObjectUtil.defaultIfNull(調査委託区分, RString.EMPTY));
        dataPass.set訪問調査先名称(ObjectUtil.defaultIfNull(訪問調査先名称, AtenaMeisho.EMPTY));
        dataPass.set訪問調査先郵便番号(ObjectUtil.defaultIfNull(訪問調査先郵便番号, YubinNo.EMPTY));
        dataPass.set訪問調査先住所(ObjectUtil.defaultIfNull(訪問調査先住所, AtenaJusho.EMPTY));
        dataPass.set訪問調査先電話番号(ObjectUtil.defaultIfNull(訪問調査先電話番号, TelNo.EMPTY));
        dataPass.set主治医コード(ObjectUtil.defaultIfNull(主治医コード, RString.EMPTY));
        dataPass.set主治医氏名(ObjectUtil.defaultIfNull(主治医氏名, RString.EMPTY));
        dataPass.set主治医医療機関コード(ObjectUtil.defaultIfNull(主治医医療機関コード, RString.EMPTY));
        dataPass.set医療機関名称(ObjectUtil.defaultIfNull(医療機関名称, RString.EMPTY));
        dataPass.set主治医郵便番号(ObjectUtil.defaultIfNull(主治医郵便番号, YubinNo.EMPTY));
        dataPass.set主治医住所(ObjectUtil.defaultIfNull(主治医住所, RString.EMPTY));
        dataPass.set主治医電話番号(ObjectUtil.defaultIfNull(主治医電話番号, TelNo.EMPTY));
        dataPass.set主治医意見書作成依頼年月日(ObjectUtil.defaultIfNull(主治医意見書作成依頼年月日, FlexibleDate.EMPTY));
        dataPass.set主治医意見書登録予定年月日(ObjectUtil.defaultIfNull(主治医意見書登録予定年月日, FlexibleDate.EMPTY));
        dataPass.set主治医意見書記入年月日(ObjectUtil.defaultIfNull(主治医意見書記入年月日, FlexibleDate.EMPTY));
        dataPass.set要介護認定一次判定結果コード(ObjectUtil.defaultIfNull(要介護認定一次判定結果コード, Code.EMPTY));
        dataPass.set要介護認定一次判定年月日(ObjectUtil.defaultIfNull(要介護認定一次判定年月日, FlexibleDate.EMPTY));
        dataPass.set要介護認定一次判定結果コード_認知症加算(ObjectUtil.defaultIfNull(要介護認定一次判定結果コード_認知症加算, Code.EMPTY));
        dataPass.set介護認定審査会資料作成年月日(ObjectUtil.defaultIfNull(介護認定審査会資料作成年月日, FlexibleDate.EMPTY.toRDate()));
        dataPass.set認定審査会予定年月日(ObjectUtil.defaultIfNull(認定審査会予定年月日, RDate.MIN));
        dataPass.set二次判定年月日(ObjectUtil.defaultIfNull(二次判定年月日, RDate.MIN));
        dataPass.set二次判定要介護状態区分コード(ObjectUtil.defaultIfNull(二次判定要介護状態区分コード, Code.EMPTY));
        dataPass.set二次判定認定有効開始年月日(ObjectUtil.defaultIfNull(二次判定認定有効開始年月日, FlexibleDate.EMPTY));
        dataPass.set二次判定認定有効終了年月日(ObjectUtil.defaultIfNull(二次判定認定有効終了年月日, FlexibleDate.EMPTY));
        dataPass.set延期通知発行年月日(ObjectUtil.defaultIfNull(延期通知発行年月日, FlexibleDate.EMPTY.toRDate()));
        dataPass.set申請書管理番号(ObjectUtil.defaultIfNull(申請書管理番号, ShinseishoKanriNo.EMPTY));
        dataPass.set厚労省IF識別コード(ObjectUtil.defaultIfNull(厚労省IF識別コード, Code.EMPTY));
        dataPass.set市町村コード(ObjectUtil.defaultIfNull(市町村コード, LasdecCode.EMPTY));
        dataPass.set指定医フラグ(指定医フラグ);
        dataPass.set延期通知発行回数(延期通知発行回数);
        dataPass.set二次判定認定有効期間(二次判定認定有効期間);
        return dataPass;
    }

    /**
     * 調査状況用のデータを設定
     *
     * @param dataPass 調査状況用情報
     */
    public void set調査状況用情報(NinteiChosaJokyoDataPass dataPass) {
        this.認定調査員コード = dataPass.get認定調査員コード();
        this.調査員氏名 = dataPass.get調査員氏名();
        this.認定調査委託先コード = dataPass.get認定調査委託先コード();
        this.事業者名称 = dataPass.get事業者名称();
        this.認定郵便番号 = dataPass.get認定郵便番号();
        this.認定住所 = dataPass.get認定住所();
        this.認定電話番号 = dataPass.get認定電話番号();
        this.認定調査依頼年月日 = dataPass.get認定調査依頼年月日();
        this.認定調査予定年月日 = dataPass.get認定調査予定年月日();
        this.認定調査実施年月日 = dataPass.get認定調査実施年月日();
        this.調査委託区分 = dataPass.get調査委託区分();
        this.訪問調査先名称 = dataPass.get訪問調査先名称();
        this.訪問調査先郵便番号 = dataPass.get訪問調査先郵便番号();
        this.訪問調査先住所 = dataPass.get訪問調査先住所();
        this.訪問調査先電話番号 = dataPass.get訪問調査先電話番号();
        this.主治医コード = dataPass.get主治医コード();
        this.主治医氏名 = dataPass.get主治医氏名();
        this.主治医医療機関コード = dataPass.get主治医医療機関コード();
        this.医療機関名称 = dataPass.get医療機関名称();
        this.主治医郵便番号 = dataPass.get主治医郵便番号();
        this.主治医住所 = dataPass.get主治医住所();
        this.主治医電話番号 = dataPass.get主治医電話番号();
        this.主治医意見書作成依頼年月日 = dataPass.get主治医意見書作成依頼年月日();
        this.主治医意見書登録予定年月日 = dataPass.get主治医意見書登録予定年月日();
        this.主治医意見書記入年月日 = dataPass.get主治医意見書記入年月日();
        this.指定医フラグ = dataPass.is指定医フラグ();
        this.要介護認定一次判定結果コード = dataPass.get要介護認定一次判定結果コード();
        this.要介護認定一次判定年月日 = dataPass.get要介護認定一次判定年月日();
        this.要介護認定一次判定結果コード_認知症加算 = dataPass.get要介護認定一次判定結果コード_認知症加算();
        this.介護認定審査会資料作成年月日 = dataPass.get介護認定審査会資料作成年月日();
        this.認定審査会予定年月日 = dataPass.get認定審査会予定年月日();
        this.二次判定年月日 = dataPass.get二次判定年月日();
        this.二次判定要介護状態区分コード = dataPass.get二次判定要介護状態区分コード();
        this.二次判定認定有効期間 = dataPass.get二次判定認定有効期間();
        this.二次判定認定有効開始年月日 = dataPass.get二次判定認定有効開始年月日();
        this.二次判定認定有効終了年月日 = dataPass.get二次判定認定有効終了年月日();
        this.延期通知発行年月日 = dataPass.get延期通知発行年月日();
        this.延期通知発行回数 = dataPass.get延期通知発行回数();
        this.申請書管理番号 = dataPass.get申請書管理番号();
        this.厚労省IF識別コード = dataPass.get厚労省IF識別コード();
        this.市町村コード = dataPass.get市町村コード();

    }

    /**
     * このEntityのcloneを返します。
     *
     * @return このEntityのclone
     */
    @Override
    public RirekiShuseiDataPass clone() {
        try {
            return (RirekiShuseiDataPass) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new SystemException(e);
        }
    }
}
