/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.hihokenshashoa4;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 介護保険被保険者証リスト一覧表情報です。
 *
 * @reamsid_L DBU-0490-070 suguangjun
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HihokenshashoA4BodyItem {

    private RString yukokigen1;
    private RString yukokigen2;
    private RString hihokenshanno;
    private RString yubinno;
    private RString gyoseiku;
    private RString gyoseikuS;
    private RString hihojusho;
    private RString hihokana;
    private RString hihoname;
    private RString umareG;
    private RString umareYyyy;
    private RString umareYy;
    private RString umareMm;
    private RString umareDd;
    private RString seibetsu;
    private RString kofuymd;
    private RString saikofu1;
    private RString hokenshano1;
    private RString hokenshano2;
    private RString hokenshano3;
    private RString hokenshano4;
    private RString hokenshano5;
    private RString hokenshano6;
    private RString kaigokbn;
    private RString ninteiymd;
    private RString yukokikanst;
    private RString yukokikannamisen;
    private RString yukokikaned;
    private RString homonkikanst;
    private RString homonkikannamisen;
    private RString homonkikaned;
    private RString service1;
    private RString ten0;
    private RString shurui1;
    private RString shurui2;
    private RString shurui3;
    private RString shurui4;
    private RString shurui5;
    private RString shurui6;
    private RString shuruigendo1;
    private RString shuruigendo2;
    private RString shuruigendo3;
    private RString shuruigendo4;
    private RString shuruigendo5;
    private RString shuruigendo6;
    private RString ten1;
    private RString ten2;
    private RString ten3;
    private RString ten4;
    private RString ten5;
    private RString ten6;
    private RString ryui;
    private RString saikofu2;
    private RString seigen1;
    private RString seigenLong1;
    private RString seigen2;
    private RString seigenLong2;
    private RString seigen3;
    private RString seigenLong3;
    private RString seigen4;
    private RString seigenLong4;
    private RString seigen5;
    private RString seigenLong5;
    private RString seigen6;
    private RString seigenLong6;
    private RString seigenSt1;
    private RString seigenEd1;
    private RString seigenSt2;
    private RString seigenEd2;
    private RString seigenSt3;
    private RString seigenEd3;
    private RString gyosha1;
    private RString todokeYmd1;
    private RString gyosha2;
    private RString gyosha2Asa;
    private RString gyosha2Massho;
    private RString todokeYmd2;
    private RString todokeYmd2Asa;
    private RString todokeYmd2Massho;
    private RString gyosha3;
    private RString gyosha3Asa;
    private RString gyosha3Massho;
    private RString todokeYmd3;
    private RString todokeYmd3Asa;
    private RString todokeYmd3Massho;
    private RString shisetsuSyu1;
    private RString shisetsuname1;
    private RString nyushochk1;
    private RString nyuinchk1;
    private RString taishochk1;
    private RString taiinchk1;
    private RString nyushoymd1;
    private RString taiinymd1;
    private RString shisetsuSyu2;
    private RString shisetsuname2;
    private RString nyushochk2;
    private RString nyuinchk2;
    private RString taishochk2;
    private RString taiinchk2;
    private RString nyushoymd2;
    private RString taiinymd2;
    private RString renban;
    private RString seiShogai11;
    private RString seiShogai12;
    private RString kosekiSeibetsu11;
    private RString kosekiSeibetsu12;
    private RString itakuGyosha1;
    private RString itakuGyosha2;
    private RString itakuGyosha2Asa;
    private RString itakuGyosha2Massho;
    private RString itakuGyosha3;
    private RString itakuGyosha3Asa;
    private RString itakuGyosha3Massho;
    private RString imageField1;

    /**
     * インスタンスを生成します。
     *
     * @param yukokigen1 有効期限1
     * @param yukokigen2 有効期限2
     * @param hihokenshanno 被保険者番号
     * @param yubinno 郵便番号
     * @param gyoseiku 行政区
     * @param gyoseikuS 行政区S
     * @param hihojusho 住所
     * @param hihokana 氏名カナ
     * @param hihoname 氏名
     * @param umareG 生年月日の年号
     * @param umareYyyy 生年月日の年
     * @param umareYy 生年月日の年
     * @param umareMm 生年月日の月
     * @param umareDd 生年月日の日
     * @param kofuymd 交付年月日の年号
     * @param seibetsu 性別
     * @param saikofu1 再交付1
     * @param hokenshano1 保険者NO1
     * @param hokenshano2 保険者NO2
     * @param hokenshano3 保険者NO3
     * @param hokenshano4 保険者NO4
     * @param hokenshano5 保険者NO5
     * @param hokenshano6 保険者NO6
     * @param kaigokbn 要介護認定区分
     * @param ninteiymd 認定年月日
     * @param yukokikanst 認定有効期間開始
     * @param yukokikannamisen 有効期間波線
     * @param yukokikaned 認定有効期間終了
     * @param homonkikanst 訪問期間開始
     * @param homonkikannamisen 訪問期間波線
     * @param homonkikaned 訪問期間終了
     * @param service1 サービス
     * @param ten0 点数
     * @param shurui1 サービス種類1
     * @param shurui2 サービス種類2
     * @param shurui3 サービス種類3
     * @param shurui4 サービス種類4
     * @param shurui5 サービス種類5
     * @param shurui6 サービス種類6
     * @param shuruigendo1 サービス種類つ目の限度額1
     * @param shuruigendo2 サービス種類2つ目の限度額2
     * @param shuruigendo3 サービス種類3つ目の限度額3
     * @param shuruigendo4 サービス種類4つ目の限度額4
     * @param shuruigendo5 サービス種類5つ目の限度額5
     * @param shuruigendo6 サービス種類6つ目の限度額6
     * @param ten1 点数1
     * @param ten2 点数2
     * @param ten3 点数3
     * @param ten4 点数4
     * @param ten5 点数5
     * @param ten6 点数6
     * @param ryui 認定審査会意見等
     * @param saikofu2 再交付2
     * @param seigen1 給付制限1
     * @param seigenLong1 給付制限長1
     * @param seigen2 給付制限2
     * @param seigenLong2 給付制限長2
     * @param seigen3 給付制限3
     * @param seigenLong3 給付制限長3
     * @param seigen4 給付制限4
     * @param seigenLong4 給付制限長4
     * @param seigen5 給付制限5
     * @param seigenLong5 給付制限長5
     * @param seigen6 給付制限6
     * @param seigenLong6 給付制限長6
     * @param seigenSt1 給付制限開始年月日1
     * @param seigenEd1 給付制限終了年月日1
     * @param seigenSt2 給付制限開始年月日2
     * @param seigenEd2 給付制限終了年月日2
     * @param seigenSt3 給付制限開始年月日3
     * @param seigenEd3 給付制限終了年月日3
     * @param gyosha1 居宅介護事業者１
     * @param todokeYmd1 届出年月日1
     * @param gyosha2 居宅介護事業者2
     * @param gyosha2Asa 居宅介護事業者★2
     * @param gyosha2Massho 居宅介護事業者取消2
     * @param todokeYmd2 届出年月日2
     * @param todokeYmd2Asa 届出年月日★2
     * @param todokeYmd2Massho 届出年月日取消2
     * @param gyosha3 居宅介護事業者3
     * @param gyosha3Asa 居宅介護事業者★3
     * @param todokeYmd3 届出年月日3
     * @param gyosha3Massho 居宅介護事業者取消3
     * @param shisetsuSyu1 施設種類1
     * @param todokeYmd3Asa 届出年月日★3
     * @param todokeYmd3Massho 届出年月日取消3
     * @param shisetsuname1 施設名1
     * @param nyushochk1 入所チェック1
     * @param nyuinchk1 入院チェック1
     * @param taishochk1 退所チェック1
     * @param taiinchk1 入所チェック1
     * @param nyushoymd1 入所年月日1
     * @param taiinymd1 退院年月日1
     * @param shisetsuSyu2 施設種類2
     * @param shisetsuname2 施設名2
     * @param nyushochk2 入所チェック2
     * @param nyuinchk2 入院チェック2
     * @param taishochk2 退所チェック2
     * @param taiinchk2 入所チェック2
     * @param nyushoymd2 入所年月日2
     * @param taiinymd2 退院年月日2
     * @param renban 連番
     * @param seiShogai11 性障害11
     * @param seiShogai12 性障害12
     * @param kosekiSeibetsu11 構成性別11
     * @param kosekiSeibetsu12 構成性別12
     * @param itakuGyosha1 居宅介護事業者長１
     * @param itakuGyosha2 居宅介護事業者長2
     * @param itakuGyosha2Asa 居宅介護事業者長★2
     * @param itakuGyosha2Massho 居宅介護事業者長取消2
     * @param itakuGyosha3 居宅介護事業者長3
     * @param itakuGyosha3Asa 居宅介護事業者長★3
     * @param itakuGyosha3Massho 居宅介護事業者長取消3
     * @param imageField1 複合コントロール
     */
    public HihokenshashoA4BodyItem(RString yukokigen1,
            RString yukokigen2,
            RString hihokenshanno,
            RString yubinno,
            RString gyoseiku,
            RString gyoseikuS,
            RString hihojusho,
            RString hihokana,
            RString hihoname,
            RString umareG,
            RString umareYyyy,
            RString umareYy,
            RString umareMm,
            RString umareDd,
            RString seibetsu,
            RString kofuymd,
            RString saikofu1,
            RString hokenshano1,
            RString hokenshano2,
            RString hokenshano3,
            RString hokenshano4,
            RString hokenshano5,
            RString hokenshano6,
            RString kaigokbn,
            RString ninteiymd,
            RString yukokikanst,
            RString yukokikannamisen,
            RString yukokikaned,
            RString homonkikanst,
            RString homonkikannamisen,
            RString homonkikaned,
            RString service1,
            RString ten0,
            RString shurui1,
            RString shurui2,
            RString shurui3,
            RString shurui4,
            RString shurui5,
            RString shurui6,
            RString shuruigendo1,
            RString shuruigendo2,
            RString shuruigendo3,
            RString shuruigendo4,
            RString shuruigendo5,
            RString shuruigendo6,
            RString ten1,
            RString ten2,
            RString ten3,
            RString ten4,
            RString ten5,
            RString ten6,
            RString ryui,
            RString saikofu2,
            RString seigen1,
            RString seigenLong1,
            RString seigen2,
            RString seigenLong2,
            RString seigen3,
            RString seigenLong3,
            RString seigen4,
            RString seigenLong4,
            RString seigen5,
            RString seigenLong5,
            RString seigen6,
            RString seigenLong6,
            RString seigenSt1,
            RString seigenEd1,
            RString seigenSt2,
            RString seigenEd2,
            RString seigenSt3,
            RString seigenEd3,
            RString gyosha1,
            RString todokeYmd1,
            RString gyosha2,
            RString gyosha2Asa,
            RString gyosha2Massho,
            RString todokeYmd2,
            RString todokeYmd2Asa,
            RString todokeYmd2Massho,
            RString gyosha3,
            RString gyosha3Asa,
            RString gyosha3Massho,
            RString todokeYmd3,
            RString todokeYmd3Asa,
            RString todokeYmd3Massho,
            RString shisetsuSyu1,
            RString shisetsuname1,
            RString nyushochk1,
            RString nyuinchk1,
            RString taishochk1,
            RString taiinchk1,
            RString nyushoymd1,
            RString taiinymd1,
            RString shisetsuSyu2,
            RString shisetsuname2,
            RString nyushochk2,
            RString nyuinchk2,
            RString taishochk2,
            RString taiinchk2,
            RString nyushoymd2,
            RString taiinymd2,
            RString renban,
            RString seiShogai11,
            RString seiShogai12,
            RString kosekiSeibetsu11,
            RString kosekiSeibetsu12,
            RString itakuGyosha1,
            RString itakuGyosha2,
            RString itakuGyosha2Asa,
            RString itakuGyosha2Massho,
            RString itakuGyosha3,
            RString itakuGyosha3Asa,
            RString itakuGyosha3Massho,
            RString imageField1) {
        this.yukokigen1 = yukokigen1;
        this.yukokigen2 = yukokigen2;
        this.hihokenshanno = hihokenshanno;
        this.yubinno = yubinno;
        this.gyoseiku = gyoseiku;
        this.gyoseikuS = gyoseikuS;
        this.hihojusho = hihojusho;
        this.hihokana = hihokana;
        this.hihoname = hihoname;
        this.umareG = umareG;
        this.umareYyyy = umareYyyy;
        this.umareYy = umareYy;
        this.umareMm = umareMm;
        this.umareDd = umareDd;
        this.seibetsu = seibetsu;
        this.kofuymd = kofuymd;
        this.saikofu1 = saikofu1;
        this.hokenshano1 = hokenshano1;
        this.hokenshano2 = hokenshano2;
        this.hokenshano3 = hokenshano3;
        this.hokenshano4 = hokenshano4;
        this.hokenshano5 = hokenshano5;
        this.hokenshano6 = hokenshano6;
        this.kaigokbn = kaigokbn;
        this.ninteiymd = ninteiymd;
        this.yukokikanst = yukokikanst;
        this.yukokikannamisen = yukokikannamisen;
        this.yukokikaned = yukokikaned;
        this.homonkikanst = homonkikanst;
        this.homonkikannamisen = homonkikannamisen;
        this.homonkikaned = homonkikaned;
        this.service1 = service1;
        this.ten0 = ten0;
        this.shurui1 = shurui1;
        this.shurui2 = shurui2;
        this.shurui3 = shurui3;
        this.shurui4 = shurui4;
        this.shurui5 = shurui5;
        this.shurui6 = shurui6;
        this.shuruigendo1 = shuruigendo1;
        this.shuruigendo2 = shuruigendo2;
        this.shuruigendo3 = shuruigendo3;
        this.shuruigendo4 = shuruigendo4;
        this.shuruigendo5 = shuruigendo5;
        this.shuruigendo6 = shuruigendo6;
        this.ten1 = ten1;
        this.ten2 = ten2;
        this.ten3 = ten3;
        this.ten4 = ten4;
        this.ten5 = ten5;
        this.ten6 = ten6;
        this.ryui = ryui;
        this.saikofu2 = saikofu2;
        this.seigen1 = seigen1;
        this.seigenLong1 = seigenLong1;
        this.seigen2 = seigen2;
        this.seigenLong2 = seigenLong2;
        this.seigen3 = seigen3;
        this.seigenLong3 = seigenLong3;
        this.seigen4 = seigen4;
        this.seigenLong4 = seigenLong4;
        this.seigen5 = seigen5;
        this.seigenLong5 = seigenLong5;
        this.seigen6 = seigen6;
        this.seigenLong6 = seigenLong6;
        this.seigenSt1 = seigenSt1;
        this.seigenEd1 = seigenEd1;
        this.seigenSt2 = seigenSt2;
        this.seigenEd2 = seigenEd2;
        this.seigenSt3 = seigenSt3;
        this.seigenEd3 = seigenEd3;
        this.gyosha1 = gyosha1;
        this.todokeYmd1 = todokeYmd1;
        this.gyosha2 = gyosha2;
        this.gyosha2Asa = gyosha2Asa;
        this.gyosha2Massho = gyosha2Massho;
        this.todokeYmd2 = todokeYmd2;
        this.todokeYmd2Asa = todokeYmd2Asa;
        this.todokeYmd2Massho = todokeYmd2Massho;
        this.gyosha3 = gyosha3;
        this.gyosha3Asa = gyosha3Asa;
        this.gyosha3Massho = gyosha3Massho;
        this.todokeYmd3 = todokeYmd3;
        this.todokeYmd3Asa = todokeYmd3Asa;
        this.todokeYmd3Massho = todokeYmd3Massho;
        this.shisetsuSyu1 = shisetsuSyu1;
        this.shisetsuname1 = shisetsuname1;
        this.nyushochk1 = nyushochk1;
        this.nyuinchk1 = nyuinchk1;
        this.taishochk1 = taishochk1;
        this.taiinchk1 = taiinchk1;
        this.nyushoymd1 = nyushoymd1;
        this.taiinymd1 = taiinymd1;
        this.shisetsuSyu2 = shisetsuSyu2;
        this.shisetsuname2 = shisetsuname2;
        this.nyushochk2 = nyushochk2;
        this.nyuinchk2 = nyuinchk2;
        this.taishochk2 = taishochk2;
        this.taiinchk2 = taiinchk2;
        this.nyushoymd2 = nyushoymd2;
        this.taiinymd2 = taiinymd2;
        this.renban = renban;
        this.seiShogai11 = seiShogai11;
        this.seiShogai12 = seiShogai12;
        this.kosekiSeibetsu11 = kosekiSeibetsu11;
        this.kosekiSeibetsu12 = kosekiSeibetsu12;
        this.itakuGyosha1 = itakuGyosha1;
        this.itakuGyosha2 = itakuGyosha2;
        this.itakuGyosha2Asa = itakuGyosha2Asa;
        this.itakuGyosha2Massho = itakuGyosha2Massho;
        this.itakuGyosha3 = itakuGyosha3;
        this.itakuGyosha3Asa = itakuGyosha3Asa;
        this.itakuGyosha3Massho = itakuGyosha3Massho;
        this.imageField1 = imageField1;
    }
}
