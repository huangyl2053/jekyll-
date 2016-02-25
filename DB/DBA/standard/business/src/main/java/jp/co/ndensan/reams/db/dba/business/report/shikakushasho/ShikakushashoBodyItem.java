/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.shikakushasho;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 *
 * 介護保険資格者証リスト一覧表情報です。
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShikakushashoBodyItem {

    private final RString subTitle;
    private final RString yukoKigen;
    private final RString hihokenshaNo;
    private final RString jusho;
    private final RString hihokenshaNameKana;
    private final RString hihokenshaName;
    private final RString seibetsu;
    private final RString birthYMD;
    private final RString kofuYMD;
    private final RString yokaigoJotaiKubun;
    private final RString ninteiYMD;
    private final RString yukoKaishiYMD;
    private final RString yukoShuryoYMD;
    private final RString kubunShikyuTanisu;
    private final RString kubunShikyuYukoKaishiYMD;
    private final RString kubunShikyuYukoShuryoYMD;
    private final RString kubunShikyuTaniShurui;
    private final RString kubunShikyuTani;
    
    private final RString shuruiShikyuServiceName;
    private final RString shuruiShikyuTnisu;
    private final RString shuruiShikyuTani;
    private final RString serviceRyui;
    private final RString kyufuseigenNaiyo;
    private final RString kyufuseigenKaishiYMD;
    private final RString kyufuseigenShuryoYMD;
    private final RString keikakuJigyoshaName1;
    private final RString keikakuTodokedeYMD1;
    private final RString nyushoShisetsuShurui1;
    private final RString nyushoShisetsuName1;
    private final RString shisetsuNyusho1;
    private final RString shisetsuNyuin1;
    private final RString shisetsuNyushoYMD1;
    private final RString shisetsuTaisho1;
    private final RString shisetsuTaiin1;
    private final RString shisetsuTaishoYMD1;
    private final RString nyushoShisetsuShurui2;
    private final RString nyushoShisetsuName2;
    private final RString shisetsuNyusho2;
    private final RString shisetsuNyuin2;
    private final RString shisetsuNyushoYMD2;
    private final RString shisetsuTaisho2;
    private final RString shisetsuTaiin2;
    private final RString shisetsuTaishoYMD2;
    private final RString hokenshaNo1;
    private final RString hokenshaNo2;
    private final RString hokenshaNo3;
    private final RString hokenshaNo4;
    private final RString hokenshaNo5;
    private final RString hokenshaNo6;
    private final RString hokenshaJusho;
    private final RString hokenshaName;
    private final RString hokenshaTelno;
    private final RString remban;
    private final RString denshiKoin;

    /**
     * インスタンスを生成します。
     *
     * @param subTitle サブタイトル
     * @param yukoKigen 有効期限
     * @param hihokenshaNo 被保険者番号
     * @param jusho 被保険者住所
     * @param hihokenshaNameKana 被保険者フリガナ
     * @param hihokenshaName 被保険者氏名
     * @param seibetsu 性別
     * @param birthYMD 生年月日
     * @param kofuYMD 交付年月日
     * @param yokaigoJotaiKubun 要介護状態区分等
     * @param ninteiYMD 認定年月日
     * @param yukoKaishiYMD 認定の有効期間開始
     * @param yukoShuryoYMD 認定の有効期間終了
     * @param kubunShikyuTanisu 区分支給単位数
     * @param kubunShikyuYukoKaishiYMD 区分支給限度期間開始
     * @param kubunShikyuYukoShuryoYMD 区分支給限度期間終了
     * @param kubunShikyuTaniShurui 居宅サービス等の単位種類
     * @param kubunShikyuTani 居宅サービス等の単位
     * @param shuruiShikyuServiceName サービスの種類
     * @param shuruiShikyuTnisu サービス単位数
     * @param shuruiShikyuTani サービス単位
     * @param serviceRyui 認定審査会の意見及びサービスの種類
     * @param kyufuseigenNaiyo 給付制限の内容
     * @param kyufuseigenKaishiYMD 給付制限の開始年月日
     * @param kyufuseigenShuryoYMD 給付制限の終了年月日
     * @param keikakuJigyoshaName1 計画事業者名称1
     * @param keikakuTodokedeYMD1 事業所届出年月日1
     * @param nyushoShisetsuShurui1 介護保険施設等の種類1
     * @param nyushoShisetsuName1 介護保険施設等の名称1
     * @param shisetsuNyusho1 施設入所1
     * @param shisetsuNyuin1 施設入院1
     * @param shisetsuNyushoYMD1 介護保険施設等の入所年月日1
     * @param shisetsuTaisho1 施設退所1
     * @param shisetsuTaiin1 施設退院1
     * @param shisetsuTaishoYMD1 介護保険施設等の退所年月日１
     * @param nyushoShisetsuShurui2 介護保険施設等の種類2
     * @param nyushoShisetsuName2 介護保険施設等の名称2
     * @param shisetsuNyusho2 施設入所2
     * @param shisetsuNyuin2 施設入院2
     * @param shisetsuNyushoYMD2 介護保険施設等の入所年月日2
     * @param shisetsuTaisho2 施設退所2
     * @param shisetsuTaiin2 施設退院2
     * @param shisetsuTaishoYMD2 介護保険施設等の退所年月日２
     * @param hokenshaNo1 保険者番号1
     * @param hokenshaNo2 保険者番号2
     * @param hokenshaNo3 保険者番号3
     * @param hokenshaNo4 保険者番号4
     * @param hokenshaNo5 保険者番号5
     * @param hokenshaNo6 保険者番号6
     * @param hokenshaJusho 保険者住所
     * @param hokenshaName 保険者名称
     * @param hokenshaTelno 保険者電話番号
     * @param remban 連番
     * @param denshiKoin 電子公印
     */
    public ShikakushashoBodyItem(RString subTitle,
            RString yukoKigen,
            RString hihokenshaNo,
            RString jusho,
            RString hihokenshaNameKana,
            RString hihokenshaName,
            RString seibetsu,
            RString birthYMD,
            RString kofuYMD,
            RString yokaigoJotaiKubun,
            RString ninteiYMD,
            RString yukoKaishiYMD,
            RString yukoShuryoYMD,
            RString kubunShikyuTanisu,
            RString kubunShikyuYukoKaishiYMD,
            RString kubunShikyuYukoShuryoYMD,
            RString kubunShikyuTaniShurui,
            RString kubunShikyuTani,
            RString shuruiShikyuServiceName,
            RString shuruiShikyuTnisu,
            RString shuruiShikyuTani,
            RString serviceRyui,
            RString kyufuseigenNaiyo,
            RString kyufuseigenKaishiYMD,
            RString kyufuseigenShuryoYMD,
            RString keikakuJigyoshaName1,
            RString keikakuTodokedeYMD1,
            RString nyushoShisetsuShurui1,
            RString nyushoShisetsuName1,
            RString shisetsuNyusho1,
            RString shisetsuNyuin1,
            RString shisetsuNyushoYMD1,
            RString shisetsuTaisho1,
            RString shisetsuTaiin1,
            RString shisetsuTaishoYMD1,
            RString nyushoShisetsuShurui2,
            RString nyushoShisetsuName2,
            RString shisetsuNyusho2,
            RString shisetsuNyuin2,
            RString shisetsuNyushoYMD2,
            RString shisetsuTaisho2,
            RString shisetsuTaiin2,
            RString shisetsuTaishoYMD2,
            RString hokenshaNo1,
            RString hokenshaNo2,
            RString hokenshaNo3,
            RString hokenshaNo4,
            RString hokenshaNo5,
            RString hokenshaNo6,
            RString hokenshaJusho,
            RString hokenshaName,
            RString hokenshaTelno,
            RString remban,
            RString denshiKoin) {
        this.subTitle = subTitle;
        this.yukoKigen = yukoKigen;
        this.hihokenshaNo = hihokenshaNo;
        this.jusho = jusho;
        this.hihokenshaNameKana = hihokenshaNameKana;
        this.hihokenshaName = hihokenshaName;
        this.seibetsu = seibetsu;
        this.birthYMD = birthYMD;
        this.kofuYMD = kofuYMD;
        this.yokaigoJotaiKubun = yokaigoJotaiKubun;
        this.ninteiYMD = ninteiYMD;
        this.yukoKaishiYMD = yukoKaishiYMD;
        this.yukoShuryoYMD = yukoShuryoYMD;
        this.kubunShikyuTanisu = kubunShikyuTanisu;
        this.shuruiShikyuTani = shuruiShikyuTani;
        this.kubunShikyuYukoKaishiYMD = kubunShikyuYukoKaishiYMD;
        this.kubunShikyuYukoShuryoYMD = kubunShikyuYukoShuryoYMD;
        this.kubunShikyuTaniShurui = kubunShikyuTaniShurui;
        this.kubunShikyuTani = kubunShikyuTani;
        this.shuruiShikyuServiceName = shuruiShikyuServiceName;
        this.shuruiShikyuTnisu = shuruiShikyuTnisu;
        this.serviceRyui = serviceRyui;
        this.kyufuseigenNaiyo = kyufuseigenNaiyo;
        this.kyufuseigenKaishiYMD = kyufuseigenKaishiYMD;
        this.kyufuseigenShuryoYMD = kyufuseigenShuryoYMD;
        this.keikakuJigyoshaName1 = keikakuJigyoshaName1;
        this.keikakuTodokedeYMD1 = keikakuTodokedeYMD1;
        this.nyushoShisetsuShurui1 = nyushoShisetsuShurui1;
        this.nyushoShisetsuName1 = nyushoShisetsuName1;
        this.shisetsuNyusho1 = shisetsuNyusho1;
        this.shisetsuNyuin1 = shisetsuNyuin1;
        this.shisetsuNyushoYMD1 = shisetsuNyushoYMD1;
        this.shisetsuTaisho1 = shisetsuTaisho1;
        this.shisetsuTaiin1 = shisetsuTaiin1;
        this.shisetsuTaishoYMD1 = shisetsuTaishoYMD1;
        this.nyushoShisetsuShurui2 = nyushoShisetsuShurui2;
        this.nyushoShisetsuName2 = nyushoShisetsuName2;
        this.shisetsuNyusho2 = shisetsuNyusho2;
        this.shisetsuNyuin2 = shisetsuNyuin2;
        this.shisetsuNyushoYMD2 = shisetsuNyushoYMD2;
        this.shisetsuTaisho2 = shisetsuTaisho2;
        this.shisetsuTaiin2 = shisetsuTaiin2;
        this.shisetsuTaishoYMD2 = shisetsuTaishoYMD2;
        this.hokenshaNo1 = hokenshaNo1;
        this.hokenshaNo2 = hokenshaNo2;
        this.hokenshaNo3 = hokenshaNo3;
        this.hokenshaNo4 = hokenshaNo4;
        this.hokenshaNo5 = hokenshaNo5;
        this.hokenshaNo6 = hokenshaNo6;
        this.hokenshaJusho = hokenshaJusho;
        this.hokenshaName = hokenshaName;
        this.hokenshaTelno = hokenshaTelno;
        this.remban = remban;
        this.denshiKoin = denshiKoin;
    }
}
