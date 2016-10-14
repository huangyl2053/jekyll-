/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.core.dbd710040;

import jp.co.ndensan.reams.db.dbd.business.core.dbd710040.HanyoListRiyoshaFutanGakuGengakuBusiness;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.hanyolistriyoshafutangakugengaku.RiyoshaFutanGakuGengakuEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.hanyolistriyoshafutangakugengaku.RiyoshaFutanGakuGengakuEucCsvEntity;
import jp.co.ndensan.reams.db.dbx.business.core.hokenshalist.HokenshaList;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 *
 * 汎用リスト出力(利用者負担額減免)_ＣＳＶ編集クラスです．
 *
 * @reamsid_L DBD-3950-030 panxiaobo
 */
public class HanyoListRiyoshaFutanGakuGengakuManageer {

    /**
     * HanyoListShiharaiHohoHenkoManagerのインスタンス化
     *
     * @return HanyoListShiharaiHohoHenkoManager
     */
    public static HanyoListRiyoshaFutanGakuGengakuManageer createInstance() {
        return InstanceProvider.create(HanyoListRiyoshaFutanGakuGengakuManageer.class);
    }

    /**
     * 連番ありCSV情報設定
     *
     * @param eucCsvEntity CSV情報設定情報
     * @param entity SQL取得結果情報
     * @param 地方公共団体情報 地方公共団体情報
     * @param 保険者リスト 保険者リスト
     * @param 日付スラッシュ付加 日付スラッシュ付加
     */
    public void CSV情報設定(RiyoshaFutanGakuGengakuEucCsvEntity eucCsvEntity, RiyoshaFutanGakuGengakuEntity entity,
            Association 地方公共団体情報, HokenshaList 保険者リスト, boolean 日付スラッシュ付加) {
        HanyoListRiyoshaFutanGakuGengakuBusiness bus = new HanyoListRiyoshaFutanGakuGengakuBusiness();
        bus.setEucCsvEntity(地方公共団体情報, 日付スラッシュ付加, eucCsvEntity, entity, 保険者リスト);
    }

    public RiyoshaFutanGakuGengakuEucCsvEntity setBlank() {
        RiyoshaFutanGakuGengakuEucCsvEntity eucCsvEntity = new RiyoshaFutanGakuGengakuEucCsvEntity();
        eucCsvEntity.set識別コード(RString.EMPTY);
        eucCsvEntity.set住民種別(RString.EMPTY);
        eucCsvEntity.set氏名(RString.EMPTY);
        eucCsvEntity.set氏名カナ(RString.EMPTY);
        eucCsvEntity.set生年月日(RString.EMPTY);
        eucCsvEntity.set年齢(RString.EMPTY);
        eucCsvEntity.set性別(RString.EMPTY);
        eucCsvEntity.set続柄コード(RString.EMPTY);
        eucCsvEntity.set世帯コード(RString.EMPTY);
        eucCsvEntity.set世帯主名(RString.EMPTY);
        eucCsvEntity.set住所コード(RString.EMPTY);
        eucCsvEntity.set郵便番号(RString.EMPTY);
        eucCsvEntity.set住所番地方書(RString.EMPTY);
        eucCsvEntity.set住所(RString.EMPTY);
        eucCsvEntity.set番地(RString.EMPTY);
        eucCsvEntity.set方書(RString.EMPTY);
        eucCsvEntity.set行政区コード(RString.EMPTY);
        eucCsvEntity.set行政区名(RString.EMPTY);
        eucCsvEntity.set地区１(RString.EMPTY);
        eucCsvEntity.set地区２(RString.EMPTY);
        eucCsvEntity.set地区３(RString.EMPTY);
        eucCsvEntity.set連絡先１(RString.EMPTY);
        eucCsvEntity.set連絡先２(RString.EMPTY);
        eucCsvEntity.set登録異動日(RString.EMPTY);
        eucCsvEntity.set登録事由(RString.EMPTY);
        eucCsvEntity.set登録届出日(RString.EMPTY);
        eucCsvEntity.set住定異動日(RString.EMPTY);
        eucCsvEntity.set住定事由(RString.EMPTY);
        eucCsvEntity.set住定届出日(RString.EMPTY);
        eucCsvEntity.set消除異動日(RString.EMPTY);
        eucCsvEntity.set消除事由(RString.EMPTY);
        eucCsvEntity.set消除届出日(RString.EMPTY);
        eucCsvEntity.set転出入理由(RString.EMPTY);
        eucCsvEntity.set前住所郵便番号(RString.EMPTY);
        eucCsvEntity.set前住所番地方書(RString.EMPTY);
        eucCsvEntity.set前住所(RString.EMPTY);
        eucCsvEntity.set前住所番地(RString.EMPTY);
        eucCsvEntity.set前住所方書(RString.EMPTY);
        eucCsvEntity.set市町村コード(RString.EMPTY);
        eucCsvEntity.set市町村名(RString.EMPTY);
        eucCsvEntity.set保険者コード(RString.EMPTY);
        eucCsvEntity.set保険者名(RString.EMPTY);
        eucCsvEntity.set空白(RString.EMPTY);
        eucCsvEntity.set送付先氏名(RString.EMPTY);
        eucCsvEntity.set送付先氏名カナ(RString.EMPTY);
        eucCsvEntity.set送付先住所コード(RString.EMPTY);
        eucCsvEntity.set送付先郵便番号(RString.EMPTY);
        eucCsvEntity.set送付先住所番地方書(RString.EMPTY);
        eucCsvEntity.set送付先住所(RString.EMPTY);
        eucCsvEntity.set送付先番地(RString.EMPTY);
        eucCsvEntity.set送付先方書(RString.EMPTY);
        eucCsvEntity.set送付先行政区コード(RString.EMPTY);
        eucCsvEntity.set送付先行政区名(RString.EMPTY);
        eucCsvEntity.set被保険者番号(RString.EMPTY);
        eucCsvEntity.set資格取得事由(RString.EMPTY);
        eucCsvEntity.set資格取得日(RString.EMPTY);
        eucCsvEntity.set資格取得届出日(RString.EMPTY);
        eucCsvEntity.set喪失事由(RString.EMPTY);
        eucCsvEntity.set資格喪失日(RString.EMPTY);
        eucCsvEntity.set資格喪失届日(RString.EMPTY);
        eucCsvEntity.set資格区分(RString.EMPTY);
        eucCsvEntity.set住所地特例状態(RString.EMPTY);
        eucCsvEntity.set資格証記載保険者番号(RString.EMPTY);
        eucCsvEntity.set医療保険種別(RString.EMPTY);
        eucCsvEntity.set医療保険番号(RString.EMPTY);
        eucCsvEntity.set医療保険者名(RString.EMPTY);
        eucCsvEntity.set医療保険記号番号(RString.EMPTY);
        eucCsvEntity.set特定疾病(RString.EMPTY);
        eucCsvEntity.set受給申請事由(RString.EMPTY);
        eucCsvEntity.set申請理由(RString.EMPTY);
        eucCsvEntity.set申請関係者(RString.EMPTY);
        eucCsvEntity.set本人関係(RString.EMPTY);
        eucCsvEntity.set申請氏名(RString.EMPTY);
        eucCsvEntity.set申請氏名カナ(RString.EMPTY);
        eucCsvEntity.set申請代行事業者名(RString.EMPTY);
        eucCsvEntity.set申請代行事業者名カナ(RString.EMPTY);
        eucCsvEntity.set申請者郵便番号(RString.EMPTY);
        eucCsvEntity.set申請住所(RString.EMPTY);
        eucCsvEntity.set申請連絡先(RString.EMPTY);
        eucCsvEntity.set申請事業コード(RString.EMPTY);
        eucCsvEntity.set受給申請日(RString.EMPTY);
        eucCsvEntity.set調査委託先コード(RString.EMPTY);
        eucCsvEntity.set調査員コード(RString.EMPTY);
        eucCsvEntity.set委託先名(RString.EMPTY);
        eucCsvEntity.set委託先名カナ(RString.EMPTY);
        eucCsvEntity.set委託先代表者名(RString.EMPTY);
        eucCsvEntity.set委託先代表者名カナ(RString.EMPTY);
        eucCsvEntity.set委託先郵便番号(RString.EMPTY);
        eucCsvEntity.set委託先住所(RString.EMPTY);
        eucCsvEntity.set委託先連絡先(RString.EMPTY);
        eucCsvEntity.set委託先状況(RString.EMPTY);
        eucCsvEntity.set調査員氏名(RString.EMPTY);
        eucCsvEntity.set調査員氏名カナ(RString.EMPTY);
        eucCsvEntity.set調査員性別(RString.EMPTY);
        eucCsvEntity.set調査員郵便(RString.EMPTY);
        eucCsvEntity.set調査員住所(RString.EMPTY);
        eucCsvEntity.set調査員連絡先(RString.EMPTY);
        eucCsvEntity.set調査員資格(RString.EMPTY);
        eucCsvEntity.set調査員所属機関名(RString.EMPTY);
        eucCsvEntity.set調査員状況(RString.EMPTY);
        eucCsvEntity.set医療機関コード(RString.EMPTY);
        eucCsvEntity.set主治医コード(RString.EMPTY);
        eucCsvEntity.set医療機関名称(RString.EMPTY);
        eucCsvEntity.set医療機関名称カナ(RString.EMPTY);
        eucCsvEntity.set医療機関代表者名(RString.EMPTY);
        eucCsvEntity.set医療機関代表者名カナ(RString.EMPTY);
        eucCsvEntity.set医療機関郵便番号(RString.EMPTY);
        eucCsvEntity.set医療機関住所(RString.EMPTY);
        eucCsvEntity.set医療機関連絡先(RString.EMPTY);
        eucCsvEntity.set医療機関状況(RString.EMPTY);
        eucCsvEntity.set主治医名(RString.EMPTY);
        eucCsvEntity.set主治医名カナ(RString.EMPTY);
        eucCsvEntity.set主治医性別(RString.EMPTY);
        eucCsvEntity.set主治医所属(RString.EMPTY);
        eucCsvEntity.set主治医状況(RString.EMPTY);
        eucCsvEntity.set一次判定要介護度(RString.EMPTY);
        eucCsvEntity.set調査委託日(RString.EMPTY);
        eucCsvEntity.set調査予定日(RString.EMPTY);
        eucCsvEntity.set調査終了日(RString.EMPTY);
        eucCsvEntity.set意見依頼日(RString.EMPTY);
        eucCsvEntity.set意見予定日(RString.EMPTY);
        eucCsvEntity.set意見取寄日(RString.EMPTY);
        eucCsvEntity.set資料作成日(RString.EMPTY);
        eucCsvEntity.set審査予定日(RString.EMPTY);
        eucCsvEntity.set審査回答日(RString.EMPTY);
        eucCsvEntity.set一次判定日(RString.EMPTY);
        eucCsvEntity.set要介護度(RString.EMPTY);
        eucCsvEntity.set認定開始日(RString.EMPTY);
        eucCsvEntity.set認定終了日(RString.EMPTY);
        eucCsvEntity.set認定日(RString.EMPTY);
        eucCsvEntity.set旧措置(RString.EMPTY);
        eucCsvEntity.setみなし更新認定(RString.EMPTY);
        eucCsvEntity.set審査会意見(RString.EMPTY);
        eucCsvEntity.set指定サービス種類(RString.EMPTY);
        eucCsvEntity.set受給喪失日(RString.EMPTY);
        eucCsvEntity.set直近事由(RString.EMPTY);
        setBlank2(eucCsvEntity);
        return eucCsvEntity;
    }

    private void setBlank2(RiyoshaFutanGakuGengakuEucCsvEntity eucCsvEntity) {
        eucCsvEntity.set受給状況(RString.EMPTY);
        eucCsvEntity.set異動事由コード(RString.EMPTY);
        eucCsvEntity.set異動事由追加文(RString.EMPTY);
        eucCsvEntity.set削除理由コード(RString.EMPTY);
        eucCsvEntity.set異動事由文言(RString.EMPTY);
        eucCsvEntity.set削除理由文言(RString.EMPTY);
        eucCsvEntity.set支援申請区分(RString.EMPTY);
        eucCsvEntity.set初回申請日(RString.EMPTY);
        eucCsvEntity.set初回認定日(RString.EMPTY);
        eucCsvEntity.set初回要介護度(RString.EMPTY);
        eucCsvEntity.set初回認定開始日(RString.EMPTY);
        eucCsvEntity.set初回認定終了日(RString.EMPTY);
        eucCsvEntity.set初回申請事由(RString.EMPTY);
        eucCsvEntity.set初回みなし更新(RString.EMPTY);
        eucCsvEntity.set初回当初認定有効開始日(RString.EMPTY);
        eucCsvEntity.set初回当初認定有効終了日(RString.EMPTY);
        eucCsvEntity.set初回支援申請事由(RString.EMPTY);
        eucCsvEntity.set前回申請日(RString.EMPTY);
        eucCsvEntity.set前回認定日(RString.EMPTY);
        eucCsvEntity.set前回要介護度(RString.EMPTY);
        eucCsvEntity.set前回認定開始日(RString.EMPTY);
        eucCsvEntity.set前回認定終了日(RString.EMPTY);
        eucCsvEntity.set前回受給申請事由(RString.EMPTY);
        eucCsvEntity.set前回みなし更新(RString.EMPTY);
        eucCsvEntity.set前回当初認定有効開始日(RString.EMPTY);
        eucCsvEntity.set前回当初認定有効終了日(RString.EMPTY);
        eucCsvEntity.set前回支援申請事由(RString.EMPTY);
        eucCsvEntity.set前々回申請日(RString.EMPTY);
        eucCsvEntity.set前々回認定日(RString.EMPTY);
        eucCsvEntity.set前々回要介護度(RString.EMPTY);
        eucCsvEntity.set前々回認定開始日(RString.EMPTY);
        eucCsvEntity.set前々回認定終了日(RString.EMPTY);
        eucCsvEntity.set前々回受給申請事由(RString.EMPTY);
        eucCsvEntity.set前々回みなし更新(RString.EMPTY);
        eucCsvEntity.set前々回当初認定有効開始日(RString.EMPTY);
        eucCsvEntity.set前々回当初認定有効終了日(RString.EMPTY);
        eucCsvEntity.set前々回支援申請事由(RString.EMPTY);
        eucCsvEntity.set障害高齢者自立度(RString.EMPTY);
        eucCsvEntity.set認知症高齢者自立度(RString.EMPTY);
        eucCsvEntity.set訪問支給限度額単位数(RString.EMPTY);
        eucCsvEntity.set訪問支給限度有効開始年月日(RString.EMPTY);
        eucCsvEntity.set訪問支給限度有効終了年月日(RString.EMPTY);
        eucCsvEntity.set短期入所支給限度日数(RString.EMPTY);
        eucCsvEntity.set短期入所支給限度有効開始年月日(RString.EMPTY);
        eucCsvEntity.set短期入所支給限度有効終了年月日(RString.EMPTY);
        eucCsvEntity.set当初認定有効開始年月日(RString.EMPTY);
        eucCsvEntity.set当初認定有効終了年月日(RString.EMPTY);
        eucCsvEntity.set認定延期通知書発行年月日(RString.EMPTY);
        eucCsvEntity.set認定延期通知書発行回数(RString.EMPTY);
        eucCsvEntity.set延期処理見込み開始年月日(RString.EMPTY);
        eucCsvEntity.set延期処理見込み終了年月日(RString.EMPTY);
        eucCsvEntity.set受給資格証明書発行日１(RString.EMPTY);
        eucCsvEntity.set受給資格証明書発行日２(RString.EMPTY);
        eucCsvEntity.set資格取得前申請区分(RString.EMPTY);
        eucCsvEntity.set一次判定結果重み(RString.EMPTY);
        eucCsvEntity.set指定医区分(RString.EMPTY);
        eucCsvEntity.set訪問調査先郵便番号(RString.EMPTY);
        eucCsvEntity.set訪問調査先住所(RString.EMPTY);
        eucCsvEntity.set訪問調査先名称(RString.EMPTY);
        eucCsvEntity.set訪問調査先電話番号(RString.EMPTY);
        eucCsvEntity.set指定事業者コード(RString.EMPTY);
        eucCsvEntity.set施設入所日(RString.EMPTY);
        eucCsvEntity.set施設退所日(RString.EMPTY);
        eucCsvEntity.set指定事業者名(RString.EMPTY);
        eucCsvEntity.set指定事業者名カナ(RString.EMPTY);
        eucCsvEntity.set指定事業者郵便番号(RString.EMPTY);
        eucCsvEntity.set指定事業者住所(RString.EMPTY);
        eucCsvEntity.set指定事業者代表者名(RString.EMPTY);
        eucCsvEntity.set指定事業者代表者名カナ(RString.EMPTY);
        eucCsvEntity.set指定事業者代表者役職(RString.EMPTY);
        eucCsvEntity.set指定事業者電話番号(RString.EMPTY);
        eucCsvEntity.set指定事業者ＦＡＸ番号(RString.EMPTY);
        eucCsvEntity.set指定事業者ケアマネ数(RString.EMPTY);
        eucCsvEntity.set指定事業者利用者数(RString.EMPTY);
        eucCsvEntity.set指定事業者認定日(RString.EMPTY);
        eucCsvEntity.set指定事業者取消日(RString.EMPTY);
        eucCsvEntity.set指定事業者実施地域(RString.EMPTY);
        eucCsvEntity.set転出先保険者番号(RString.EMPTY);
        eucCsvEntity.set利用者負担減免申請日(RString.EMPTY);
        eucCsvEntity.set利用者負担減免決定日(RString.EMPTY);
        eucCsvEntity.set利用者負担減免承認区分(RString.EMPTY);
        eucCsvEntity.set利用者負担減免開始日(RString.EMPTY);
        eucCsvEntity.set利用者負担減免終了日(RString.EMPTY);
        eucCsvEntity.set利用者負担減免給付率(RString.EMPTY);
        eucCsvEntity.set被保険者番号_総合事業対象者(RString.EMPTY);
        eucCsvEntity.set履歴番号(RString.EMPTY);
        eucCsvEntity.set事業適用開始日(RString.EMPTY);
        eucCsvEntity.set事業適用終了日(RString.EMPTY);
        eucCsvEntity.set事業チェック実施日(RString.EMPTY);
        eucCsvEntity.set事業決定日(RString.EMPTY);
        eucCsvEntity.set届出区分(RString.EMPTY);
        eucCsvEntity.set居宅計画作成区分(RString.EMPTY);
        eucCsvEntity.set計画事業者番号(RString.EMPTY);
        eucCsvEntity.set計画事業者名(RString.EMPTY);
        eucCsvEntity.set計画事業者カナ(RString.EMPTY);
        eucCsvEntity.set計画管理者名(RString.EMPTY);
        eucCsvEntity.set計画管理者カナ(RString.EMPTY);
        eucCsvEntity.set計画適用開始日(RString.EMPTY);
        eucCsvEntity.set計画適用終了日(RString.EMPTY);
        eucCsvEntity.set計画届出日(RString.EMPTY);
        eucCsvEntity.set計画作成日(RString.EMPTY);
        eucCsvEntity.set計画変更日(RString.EMPTY);
        eucCsvEntity.set変更理由(RString.EMPTY);
    }

}
