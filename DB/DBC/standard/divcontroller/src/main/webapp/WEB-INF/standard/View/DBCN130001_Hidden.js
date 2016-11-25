var callBackHandler = Uz._LoadInOrder.prototype.requestSequenceCallbackHandler;
Uz._LoadInOrder.prototype.requestSequenceCallbackHandler = function(eventName){
  callBackHandler.call(this,eventName);
      $("#txtUchiFutangaku8").on("onBlur", function() {
         var val8 =  $("#txtUchiFutangaku8_core").val().replace(/,/g,"");
         var val9 =  $("#txtUchiFutangaku9_core").val().replace(/,/g,"" );
         var val10 =  $("#txtUchiFutangaku10_core").val().replace(/,/g,"");
         var val11 =  $("#txtUchiFutangaku11_core").val().replace(/,/g,"");
         var val12 =  $("#txtUchiFutangaku12_core").val().replace(/,/g,"");
         var val1 =  $("#txtUchiFutangaku1_core").val().replace(/,/g,"");
         var val2 =  $("#txtUchiFutangaku2_core").val().replace(/,/g,"");
         var val3 =  $("#txtUchiFutangaku3_core").val().replace(/,/g,"");
         var val4 =  $("#txtUchiFutangaku4_core").val().replace(/,/g,"");
         var val5 =  $("#txtUchiFutangaku5_core").val().replace(/,/g,"");
         var val6 =  $("#txtUchiFutangaku6_core").val().replace(/,/g,"");
         var val7 =  $("#txtUchiFutangaku7_core").val().replace(/,/g,"");

         $("#txtUchiFutangakuGokei_core").val(fmoney( Number(val1)+Number(val2)+Number(val3)
                       +Number(val4)+Number(val5)+Number(val6)+Number(val7)+Number(val8)+Number(val9)
                       +Number(val10)+Number(val11)+Number(val12),0));
        });
        
     function fmoney(s, n)
        { 
        n = n > 0 && n <= 20 ? n : 2; 
         s = parseFloat((s + "").replace(/[^\d\.-]/g, "")).toFixed(0) + ""; 
         var l = s.split(".")[0].split("").reverse(), 
         r = s.split(".")[1]; 
         t = ""; 
         for(i = 0; i < l.length; i ++ ) 
         { 
         t += l[i] + ((i + 1) % 3 === 0 && (i + 1) !== l.length ? "," : ""); 
         } 
         return t.split("").reverse().join(""); 
         }
        
         $("#txtUchiFutangaku9").on("onBlur", function() {
            var val8 =  $("#txtUchiFutangaku8_core").val().replace(/,/g,"");
            var val9 =  $("#txtUchiFutangaku9_core").val().replace(/,/g,"");
            var val10 =  $("#txtUchiFutangaku10_core").val().replace(/,/g,"");
            var val11 =  $("#txtUchiFutangaku11_core").val().replace(/,/g,"");
            var val12 =  $("#txtUchiFutangaku12_core").val().replace(/,/g,"");
            var val1 =  $("#txtUchiFutangaku1_core").val().replace(/,/g,"");
            var val2 =  $("#txtUchiFutangaku2_core").val().replace(/,/g,"");
            var val3 =  $("#txtUchiFutangaku3_core").val().replace(/,/g,"");
            var val4 =  $("#txtUchiFutangaku4_core").val().replace(/,/g,"");
            var val5 =  $("#txtUchiFutangaku5_core").val().replace(/,/g,"");
            var val6 =  $("#txtUchiFutangaku6_core").val().replace(/,/g,"");
            var val7 =  $("#txtUchiFutangaku7_core").val().replace(/,/g,"");

            $("#txtUchiFutangakuGokei_core").val(fmoney( Number(val1)+Number(val2)+Number(val3)
                       +Number(val4)+Number(val5)+Number(val6)+Number(val7)+Number(val8)+Number(val9)
                       +Number(val10)+Number(val11)+Number(val12),0));
         });
         $("#txtUchiFutangaku10").on("onBlur", function() {
         var val8 =  $("#txtUchiFutangaku8_core").val().replace(/,/g,"");
         var val9 =  $("#txtUchiFutangaku9_core").val().replace(/,/g,"" );
         var val10 =  $("#txtUchiFutangaku10_core").val().replace(/,/g,"");
         var val11 =  $("#txtUchiFutangaku11_core").val().replace(/,/g,"");
         var val12 =  $("#txtUchiFutangaku12_core").val().replace(/,/g,"");
         var val1 =  $("#txtUchiFutangaku1_core").val().replace(/,/g,"");
         var val2 =  $("#txtUchiFutangaku2_core").val().replace(/,/g,"");
         var val3 =  $("#txtUchiFutangaku3_core").val().replace(/,/g,"");
         var val4 =  $("#txtUchiFutangaku4_core").val().replace(/,/g,"");
         var val5 =  $("#txtUchiFutangaku5_core").val().replace(/,/g,"");
         var val6 =  $("#txtUchiFutangaku6_core").val().replace(/,/g,"");
         var val7 =  $("#txtUchiFutangaku7_core").val().replace(/,/g,"");

            $("#txtUchiFutangakuGokei_core").val(fmoney( Number(val1)+Number(val2)+Number(val3)
                       +Number(val4)+Number(val5)+Number(val6)+Number(val7)+Number(val8)+Number(val9)
                       +Number(val10)+Number(val11)+Number(val12),0));
         });
         $("#txtUchiFutangaku11").on("onBlur", function() {
         var val8 =  $("#txtUchiFutangaku8_core").val().replace(/,/g,"");
         var val9 =  $("#txtUchiFutangaku9_core").val().replace(/,/g,"" );
         var val10 =  $("#txtUchiFutangaku10_core").val().replace(/,/g,"");
         var val11 =  $("#txtUchiFutangaku11_core").val().replace(/,/g,"");
         var val12 =  $("#txtUchiFutangaku12_core").val().replace(/,/g,"");
         var val1 =  $("#txtUchiFutangaku1_core").val().replace(/,/g,"");
         var val2 =  $("#txtUchiFutangaku2_core").val().replace(/,/g,"");
         var val3 =  $("#txtUchiFutangaku3_core").val().replace(/,/g,"");
         var val4 =  $("#txtUchiFutangaku4_core").val().replace(/,/g,"");
         var val5 =  $("#txtUchiFutangaku5_core").val().replace(/,/g,"");
         var val6 =  $("#txtUchiFutangaku6_core").val().replace(/,/g,"");
         var val7 =  $("#txtUchiFutangaku7_core").val().replace(/,/g,"");

            $("#txtUchiFutangakuGokei_core").val(fmoney( Number(val1)+Number(val2)+Number(val3)
                       +Number(val4)+Number(val5)+Number(val6)+Number(val7)+Number(val8)+Number(val9)
                       +Number(val10)+Number(val11)+Number(val12),0));
         });
         $("#txtUchiFutangaku12").on("onBlur", function() {
              var val8 =  $("#txtUchiFutangaku8_core").val().replace(/,/g,"");
            var val9 =  $("#txtUchiFutangaku9_core").val().replace(/,/g,"" );
            var val10 =  $("#txtUchiFutangaku10_core").val().replace(/,/g,"");
            var val11 =  $("#txtUchiFutangaku11_core").val().replace(/,/g,"");
            var val12 =  $("#txtUchiFutangaku12_core").val().replace(/,/g,"");
            var val1 =  $("#txtUchiFutangaku1_core").val().replace(/,/g,"");
            var val2 =  $("#txtUchiFutangaku2_core").val().replace(/,/g,"");
            var val3 =  $("#txtUchiFutangaku3_core").val().replace(/,/g,"");
            var val4 =  $("#txtUchiFutangaku4_core").val().replace(/,/g,"");
            var val5 =  $("#txtUchiFutangaku5_core").val().replace(/,/g,"");
            var val6 =  $("#txtUchiFutangaku6_core").val().replace(/,/g,"");
            var val7 =  $("#txtUchiFutangaku7_core").val().replace(/,/g,"");

            $("#txtUchiFutangakuGokei_core").val(fmoney( Number(val1)+Number(val2)+Number(val3)
                       +Number(val4)+Number(val5)+Number(val6)+Number(val7)+Number(val8)+Number(val9)
                       +Number(val10)+Number(val11)+Number(val12),0));
         });
         $("#txtUchiFutangaku1").on("onBlur", function() {
              var val8 =  $("#txtUchiFutangaku8_core").val().replace(/,/g,"");
         var val9 =  $("#txtUchiFutangaku9_core").val().replace(/,/g,"" );
         var val10 =  $("#txtUchiFutangaku10_core").val().replace(/,/g,"");
         var val11 =  $("#txtUchiFutangaku11_core").val().replace(/,/g,"");
         var val12 =  $("#txtUchiFutangaku12_core").val().replace(/,/g,"");
         var val1 =  $("#txtUchiFutangaku1_core").val().replace(/,/g,"");
         var val2 =  $("#txtUchiFutangaku2_core").val().replace(/,/g,"");
         var val3 =  $("#txtUchiFutangaku3_core").val().replace(/,/g,"");
         var val4 =  $("#txtUchiFutangaku4_core").val().replace(/,/g,"");
         var val5 =  $("#txtUchiFutangaku5_core").val().replace(/,/g,"");
         var val6 =  $("#txtUchiFutangaku6_core").val().replace(/,/g,"");
         var val7 =  $("#txtUchiFutangaku7_core").val().replace(/,/g,"");

            $("#txtUchiFutangakuGokei_core").val(fmoney( Number(val1)+Number(val2)+Number(val3)
                       +Number(val4)+Number(val5)+Number(val6)+Number(val7)+Number(val8)+Number(val9)
                       +Number(val10)+Number(val11)+Number(val12),0));
         });
         $("#txtUchiFutangaku2").on("onBlur", function() {
              var val8 =  $("#txtUchiFutangaku8_core").val().replace(/,/g,"");
         var val9 =  $("#txtUchiFutangaku9_core").val().replace(/,/g,"" );
         var val10 =  $("#txtUchiFutangaku10_core").val().replace(/,/g,"");
         var val11 =  $("#txtUchiFutangaku11_core").val().replace(/,/g,"");
         var val12 =  $("#txtUchiFutangaku12_core").val().replace(/,/g,"");
         var val1 =  $("#txtUchiFutangaku1_core").val().replace(/,/g,"");
         var val2 =  $("#txtUchiFutangaku2_core").val().replace(/,/g,"");
         var val3 =  $("#txtUchiFutangaku3_core").val().replace(/,/g,"");
         var val4 =  $("#txtUchiFutangaku4_core").val().replace(/,/g,"");
         var val5 =  $("#txtUchiFutangaku5_core").val().replace(/,/g,"");
         var val6 =  $("#txtUchiFutangaku6_core").val().replace(/,/g,"");
         var val7 =  $("#txtUchiFutangaku7_core").val().replace(/,/g,"");

            $("#txtUchiFutangakuGokei_core").val(fmoney( Number(val1)+Number(val2)+Number(val3)
                       +Number(val4)+Number(val5)+Number(val6)+Number(val7)+Number(val8)+Number(val9)
                       +Number(val10)+Number(val11)+Number(val12),0));
         });
         $("#txtUchiFutangaku3").on("onBlur", function() {
              var val8 =  $("#txtUchiFutangaku8_core").val().replace(/,/g,"");
         var val9 =  $("#txtUchiFutangaku9_core").val().replace(/,/g,"" );
         var val10 =  $("#txtUchiFutangaku10_core").val().replace(/,/g,"");
         var val11 =  $("#txtUchiFutangaku11_core").val().replace(/,/g,"");
         var val12 =  $("#txtUchiFutangaku12_core").val().replace(/,/g,"");
         var val1 =  $("#txtUchiFutangaku1_core").val().replace(/,/g,"");
         var val2 =  $("#txtUchiFutangaku2_core").val().replace(/,/g,"");
         var val3 =  $("#txtUchiFutangaku3_core").val().replace(/,/g,"");
         var val4 =  $("#txtUchiFutangaku4_core").val().replace(/,/g,"");
         var val5 =  $("#txtUchiFutangaku5_core").val().replace(/,/g,"");
         var val6 =  $("#txtUchiFutangaku6_core").val().replace(/,/g,"");
         var val7 =  $("#txtUchiFutangaku7_core").val().replace(/,/g,"");

            $("#txtUchiFutangakuGokei_core").val(fmoney( Number(val1)+Number(val2)+Number(val3)
                       +Number(val4)+Number(val5)+Number(val6)+Number(val7)+Number(val8)+Number(val9)
                       +Number(val10)+Number(val11)+Number(val12),0));
         });
         $("#txtUchiFutangaku4").on("onBlur", function() {
              var val8 =  $("#txtUchiFutangaku8_core").val().replace(/,/g,"");
            var val9 =  $("#txtUchiFutangaku9_core").val().replace(/,/g,"" );
            var val10 =  $("#txtUchiFutangaku10_core").val().replace(/,/g,"");
            var val11 =  $("#txtUchiFutangaku11_core").val().replace(/,/g,"");
            var val12 =  $("#txtUchiFutangaku12_core").val().replace(/,/g,"");
            var val1 =  $("#txtUchiFutangaku1_core").val().replace(/,/g,"");
            var val2 =  $("#txtUchiFutangaku2_core").val().replace(/,/g,"");
            var val3 =  $("#txtUchiFutangaku3_core").val().replace(/,/g,"");
            var val4 =  $("#txtUchiFutangaku4_core").val().replace(/,/g,"");
            var val5 =  $("#txtUchiFutangaku5_core").val().replace(/,/g,"");
            var val6 =  $("#txtUchiFutangaku6_core").val().replace(/,/g,"");
            var val7 =  $("#txtUchiFutangaku7_core").val().replace(/,/g,"");
         
            $("#txtUchiFutangakuGokei_core").val(fmoney( Number(val1)+Number(val2)+Number(val3)
                       +Number(val4)+Number(val5)+Number(val6)+Number(val7)+Number(val8)+Number(val9)
                       +Number(val10)+Number(val11)+Number(val12),0));
         });
         $("#txtUchiFutangaku5").on("onBlur", function() {
              var val8 =  $("#txtUchiFutangaku8_core").val().replace(/,/g,"");
         var val9 =  $("#txtUchiFutangaku9_core").val().replace(/,/g,"" );
         var val10 =  $("#txtUchiFutangaku10_core").val().replace(/,/g,"");
         var val11 =  $("#txtUchiFutangaku11_core").val().replace(/,/g,"");
         var val12 =  $("#txtUchiFutangaku12_core").val().replace(/,/g,"");
         var val1 =  $("#txtUchiFutangaku1_core").val().replace(/,/g,"");
         var val2 =  $("#txtUchiFutangaku2_core").val().replace(/,/g,"");
         var val3 =  $("#txtUchiFutangaku3_core").val().replace(/,/g,"");
         var val4 =  $("#txtUchiFutangaku4_core").val().replace(/,/g,"");
         var val5 =  $("#txtUchiFutangaku5_core").val().replace(/,/g,"");
         var val6 =  $("#txtUchiFutangaku6_core").val().replace(/,/g,"");
         var val7 =  $("#txtUchiFutangaku7_core").val().replace(/,/g,"");

            $("#txtUchiFutangakuGokei_core").val(fmoney( Number(val1)+Number(val2)+Number(val3)
                       +Number(val4)+Number(val5)+Number(val6)+Number(val7)+Number(val8)+Number(val9)
                       +Number(val10)+Number(val11)+Number(val12),0));
         });
         $("#txtUchiFutangaku6").on("onBlur", function() {
               var val8 =  $("#txtUchiFutangaku8_core").val().replace(/,/g,"");
         var val9 =  $("#txtUchiFutangaku9_core").val().replace(/,/g,"" );
         var val10 =  $("#txtUchiFutangaku10_core").val().replace(/,/g,"");
         var val11 =  $("#txtUchiFutangaku11_core").val().replace(/,/g,"");
         var val12 =  $("#txtUchiFutangaku12_core").val().replace(/,/g,"");
         var val1 =  $("#txtUchiFutangaku1_core").val().replace(/,/g,"");
         var val2 =  $("#txtUchiFutangaku2_core").val().replace(/,/g,"");
         var val3 =  $("#txtUchiFutangaku3_core").val().replace(/,/g,"");
         var val4 =  $("#txtUchiFutangaku4_core").val().replace(/,/g,"");
         var val5 =  $("#txtUchiFutangaku5_core").val().replace(/,/g,"");
         var val6 =  $("#txtUchiFutangaku6_core").val().replace(/,/g,"");
         var val7 =  $("#txtUchiFutangaku7_core").val().replace(/,/g,"");

            $("#txtUchiFutangakuGokei_core").val(fmoney( Number(val1)+Number(val2)+Number(val3)
                       +Number(val4)+Number(val5)+Number(val6)+Number(val7)+Number(val8)+Number(val9)
                       +Number(val10)+Number(val11)+Number(val12),0));
         });
         $("#txtUchiFutangaku7").on("onBlur", function() {
              var val8 =  $("#txtUchiFutangaku8_core").val().replace(/,/g,"");
         var val9 =  $("#txtUchiFutangaku9_core").val().replace(/,/g,"" );
         var val10 =  $("#txtUchiFutangaku10_core").val().replace(/,/g,"");
         var val11 =  $("#txtUchiFutangaku11_core").val().replace(/,/g,"");
         var val12 =  $("#txtUchiFutangaku12_core").val().replace(/,/g,"");
         var val1 =  $("#txtUchiFutangaku1_core").val().replace(/,/g,"");
         var val2 =  $("#txtUchiFutangaku2_core").val().replace(/,/g,"");
         var val3 =  $("#txtUchiFutangaku3_core").val().replace(/,/g,"");
         var val4 =  $("#txtUchiFutangaku4_core").val().replace(/,/g,"");
         var val5 =  $("#txtUchiFutangaku5_core").val().replace(/,/g,"");
         var val6 =  $("#txtUchiFutangaku6_core").val().replace(/,/g,"");
         var val7 =  $("#txtUchiFutangaku7_core").val().replace(/,/g,"");

            $("#txtUchiFutangakuGokei_core").val(fmoney( Number(val1)+Number(val2)+Number(val3)
                       +Number(val4)+Number(val5)+Number(val6)+Number(val7)+Number(val8)+Number(val9)
                       +Number(val10)+Number(val11)+Number(val12),0));
         });
         $("#txtJikofutangaku8").on("onBlur", function() {
            var val8 =  $("#txtJikofutangaku8_core").val().replace(/,/g,"");
            var val9 =  $("#txtJikofutangaku9_core").val().replace(/,/g,"");
            var val10 =  $("#txtJikofutangaku10_core").val().replace(/,/g,"");
            var val11 =  $("#txtJikofutangaku11_core").val().replace(/,/g,"");
            var val12 =  $("#txtJikofutangaku12_core").val().replace(/,/g,"");
            var val1 =  $("#txtJikofutangaku1_core").val().replace(/,/g,"");
            var val2 =  $("#txtJikofutangaku2_core").val().replace(/,/g,"");
            var val3 =  $("#txtJikofutangaku3_core").val().replace(/,/g,"");
            var val4 =  $("#txtJikofutangaku4_core").val().replace(/,/g,"");
            var val5 =  $("#txtJikofutangaku5_core").val().replace(/,/g,"");
            var val6 =  $("#txtJikofutangaku6_core").val().replace(/,/g,"");
            var val7 =  $("#txtJikofutangaku7_core").val().replace(/,/g,"");

            $("#txtJikofutangakuGokei_core").val(fmoney( Number(val1)+Number(val2)+Number(val3)
                       +Number(val4)+Number(val5)+Number(val6)+Number(val7)+Number(val8)+Number(val9)
                       +Number(val10)+Number(val11)+Number(val12),0));
         });
          $("#txtJikofutangaku9").on("onBlur", function() {
            var val8 =  $("#txtJikofutangaku8_core").val().replace(/,/g,"");
            var val9 =  $("#txtJikofutangaku9_core").val().replace(/,/g,"");
            var val10 =  $("#txtJikofutangaku10_core").val().replace(/,/g,"");
            var val11 =  $("#txtJikofutangaku11_core").val().replace(/,/g,"");
            var val12 =  $("#txtJikofutangaku12_core").val().replace(/,/g,"");
            var val1 =  $("#txtJikofutangaku1_core").val().replace(/,/g,"");
            var val2 =  $("#txtJikofutangaku2_core").val().replace(/,/g,"");
            var val3 =  $("#txtJikofutangaku3_core").val().replace(/,/g,"");
            var val4 =  $("#txtJikofutangaku4_core").val().replace(/,/g,"");
            var val5 =  $("#txtJikofutangaku5_core").val().replace(/,/g,"");
            var val6 =  $("#txtJikofutangaku6_core").val().replace(/,/g,"");
            var val7 =  $("#txtJikofutangaku7_core").val().replace(/,/g,"");

            $("#txtJikofutangakuGokei_core").val(fmoney( Number(val1)+Number(val2)+Number(val3)
                       +Number(val4)+Number(val5)+Number(val6)+Number(val7)+Number(val8)+Number(val9)
                       +Number(val10)+Number(val11)+Number(val12),0));
         });
          $("#txtJikofutangaku10").on("onBlur", function() {
            var val8 =  $("#txtJikofutangaku8_core").val().replace(/,/g,"");
            var val9 =  $("#txtJikofutangaku9_core").val().replace(/,/g,"");
            var val10 =  $("#txtJikofutangaku10_core").val().replace(/,/g,"");
            var val11 =  $("#txtJikofutangaku11_core").val().replace(/,/g,"");
            var val12 =  $("#txtJikofutangaku12_core").val().replace(/,/g,"");
            var val1 =  $("#txtJikofutangaku1_core").val().replace(/,/g,"");
            var val2 =  $("#txtJikofutangaku2_core").val().replace(/,/g,"");
            var val3 =  $("#txtJikofutangaku3_core").val().replace(/,/g,"");
            var val4 =  $("#txtJikofutangaku4_core").val().replace(/,/g,"");
            var val5 =  $("#txtJikofutangaku5_core").val().replace(/,/g,"");
            var val6 =  $("#txtJikofutangaku6_core").val().replace(/,/g,"");
            var val7 =  $("#txtJikofutangaku7_core").val().replace(/,/g,"");

            $("#txtJikofutangakuGokei_core").val(fmoney( Number(val1)+Number(val2)+Number(val3)
                       +Number(val4)+Number(val5)+Number(val6)+Number(val7)+Number(val8)+Number(val9)
                       +Number(val10)+Number(val11)+Number(val12),0));
         });
          $("#txtJikofutangaku11").on("onBlur", function() {
             var val8 =  $("#txtJikofutangaku8_core").val().replace(/,/g,"");
            var val9 =  $("#txtJikofutangaku9_core").val().replace(/,/g,"");
            var val10 =  $("#txtJikofutangaku10_core").val().replace(/,/g,"");
            var val11 =  $("#txtJikofutangaku11_core").val().replace(/,/g,"");
            var val12 =  $("#txtJikofutangaku12_core").val().replace(/,/g,"");
            var val1 =  $("#txtJikofutangaku1_core").val().replace(/,/g,"");
            var val2 =  $("#txtJikofutangaku2_core").val().replace(/,/g,"");
            var val3 =  $("#txtJikofutangaku3_core").val().replace(/,/g,"");
            var val4 =  $("#txtJikofutangaku4_core").val().replace(/,/g,"");
            var val5 =  $("#txtJikofutangaku5_core").val().replace(/,/g,"");
            var val6 =  $("#txtJikofutangaku6_core").val().replace(/,/g,"");
            var val7 =  $("#txtJikofutangaku7_core").val().replace(/,/g,"");

            $("#txtJikofutangakuGokei_core").val(fmoney( Number(val1)+Number(val2)+Number(val3)
                       +Number(val4)+Number(val5)+Number(val6)+Number(val7)+Number(val8)+Number(val9)
                       +Number(val10)+Number(val11)+Number(val12),0));
         });
          $("#txtJikofutangaku12").on("onBlur", function() {
            var val8 =  $("#txtJikofutangaku8_core").val().replace(/,/g,"");
            var val9 =  $("#txtJikofutangaku9_core").val().replace(/,/g,"");
            var val10 =  $("#txtJikofutangaku10_core").val().replace(/,/g,"");
            var val11 =  $("#txtJikofutangaku11_core").val().replace(/,/g,"");
            var val12 =  $("#txtJikofutangaku12_core").val().replace(/,/g,"");
            var val1 =  $("#txtJikofutangaku1_core").val().replace(/,/g,"");
            var val2 =  $("#txtJikofutangaku2_core").val().replace(/,/g,"");
            var val3 =  $("#txtJikofutangaku3_core").val().replace(/,/g,"");
            var val4 =  $("#txtJikofutangaku4_core").val().replace(/,/g,"");
            var val5 =  $("#txtJikofutangaku5_core").val().replace(/,/g,"");
            var val6 =  $("#txtJikofutangaku6_core").val().replace(/,/g,"");
            var val7 =  $("#txtJikofutangaku7_core").val().replace(/,/g,"");

            $("#txtJikofutangakuGokei_core").val(fmoney( Number(val1)+Number(val2)+Number(val3)
                       +Number(val4)+Number(val5)+Number(val6)+Number(val7)+Number(val8)+Number(val9)
                       +Number(val10)+Number(val11)+Number(val12),0));
         });
          $("#txtJikofutangaku1").on("onBlur", function() {
             var val8 =  $("#txtJikofutangaku8_core").val().replace(/,/g,"");
            var val9 =  $("#txtJikofutangaku9_core").val().replace(/,/g,"");
            var val10 =  $("#txtJikofutangaku10_core").val().replace(/,/g,"");
            var val11 =  $("#txtJikofutangaku11_core").val().replace(/,/g,"");
            var val12 =  $("#txtJikofutangaku12_core").val().replace(/,/g,"");
            var val1 =  $("#txtJikofutangaku1_core").val().replace(/,/g,"");
            var val2 =  $("#txtJikofutangaku2_core").val().replace(/,/g,"");
            var val3 =  $("#txtJikofutangaku3_core").val().replace(/,/g,"");
            var val4 =  $("#txtJikofutangaku4_core").val().replace(/,/g,"");
            var val5 =  $("#txtJikofutangaku5_core").val().replace(/,/g,"");
            var val6 =  $("#txtJikofutangaku6_core").val().replace(/,/g,"");
            var val7 =  $("#txtJikofutangaku7_core").val().replace(/,/g,"");

            $("#txtJikofutangakuGokei_core").val(fmoney( Number(val1)+Number(val2)+Number(val3)
                       +Number(val4)+Number(val5)+Number(val6)+Number(val7)+Number(val8)+Number(val9)
                       +Number(val10)+Number(val11)+Number(val12),0));
         });
          $("#txtJikofutangaku2").on("onBlur", function() {
            var val8 =  $("#txtJikofutangaku8_core").val().replace(/,/g,"");
            var val9 =  $("#txtJikofutangaku9_core").val().replace(/,/g,"");
            var val10 =  $("#txtJikofutangaku10_core").val().replace(/,/g,"");
            var val11 =  $("#txtJikofutangaku11_core").val().replace(/,/g,"");
            var val12 =  $("#txtJikofutangaku12_core").val().replace(/,/g,"");
            var val1 =  $("#txtJikofutangaku1_core").val().replace(/,/g,"");
            var val2 =  $("#txtJikofutangaku2_core").val().replace(/,/g,"");
            var val3 =  $("#txtJikofutangaku3_core").val().replace(/,/g,"");
            var val4 =  $("#txtJikofutangaku4_core").val().replace(/,/g,"");
            var val5 =  $("#txtJikofutangaku5_core").val().replace(/,/g,"");
            var val6 =  $("#txtJikofutangaku6_core").val().replace(/,/g,"");
            var val7 =  $("#txtJikofutangaku7_core").val().replace(/,/g,"");

            $("#txtJikofutangakuGokei_core").val(fmoney( Number(val1)+Number(val2)+Number(val3)
                       +Number(val4)+Number(val5)+Number(val6)+Number(val7)+Number(val8)+Number(val9)
                       +Number(val10)+Number(val11)+Number(val12),0));
         });
          $("#txtJikofutangaku3").on("onBlur", function() {
            var val8 =  $("#txtJikofutangaku8_core").val().replace(/,/g,"");
            var val9 =  $("#txtJikofutangaku9_core").val().replace(/,/g,"");
            var val10 =  $("#txtJikofutangaku10_core").val().replace(/,/g,"");
            var val11 =  $("#txtJikofutangaku11_core").val().replace(/,/g,"");
            var val12 =  $("#txtJikofutangaku12_core").val().replace(/,/g,"");
            var val1 =  $("#txtJikofutangaku1_core").val().replace(/,/g,"");
            var val2 =  $("#txtJikofutangaku2_core").val().replace(/,/g,"");
            var val3 =  $("#txtJikofutangaku3_core").val().replace(/,/g,"");
            var val4 =  $("#txtJikofutangaku4_core").val().replace(/,/g,"");
            var val5 =  $("#txtJikofutangaku5_core").val().replace(/,/g,"");
            var val6 =  $("#txtJikofutangaku6_core").val().replace(/,/g,"");
            var val7 =  $("#txtJikofutangaku7_core").val().replace(/,/g,"");
            
            $("#txtJikofutangakuGokei_core").val(fmoney( Number(val1)+Number(val2)+Number(val3)
                       +Number(val4)+Number(val5)+Number(val6)+Number(val7)+Number(val8)+Number(val9)
                       +Number(val10)+Number(val11)+Number(val12),0));
         });
          $("#txtJikofutangaku4").on("onBlur", function() {
             var val8 =  $("#txtJikofutangaku8_core").val().replace(/,/g,"");
            var val9 =  $("#txtJikofutangaku9_core").val().replace(/,/g,"");
            var val10 =  $("#txtJikofutangaku10_core").val().replace(/,/g,"");
            var val11 =  $("#txtJikofutangaku11_core").val().replace(/,/g,"");
            var val12 =  $("#txtJikofutangaku12_core").val().replace(/,/g,"");
            var val1 =  $("#txtJikofutangaku1_core").val().replace(/,/g,"");
            var val2 =  $("#txtJikofutangaku2_core").val().replace(/,/g,"");
            var val3 =  $("#txtJikofutangaku3_core").val().replace(/,/g,"");
            var val4 =  $("#txtJikofutangaku4_core").val().replace(/,/g,"");
            var val5 =  $("#txtJikofutangaku5_core").val().replace(/,/g,"");
            var val6 =  $("#txtJikofutangaku6_core").val().replace(/,/g,"");
            var val7 =  $("#txtJikofutangaku7_core").val().replace(/,/g,"");

            $("#txtJikofutangakuGokei_core").val(fmoney( Number(val1)+Number(val2)+Number(val3)
                       +Number(val4)+Number(val5)+Number(val6)+Number(val7)+Number(val8)+Number(val9)
                       +Number(val10)+Number(val11)+Number(val12),0));
         });
          $("#txtJikofutangaku5").on("onBlur", function() {
             var val8 =  $("#txtJikofutangaku8_core").val().replace(/,/g,"");
            var val9 =  $("#txtJikofutangaku9_core").val().replace(/,/g,"");
            var val10 =  $("#txtJikofutangaku10_core").val().replace(/,/g,"");
            var val11 =  $("#txtJikofutangaku11_core").val().replace(/,/g,"");
            var val12 =  $("#txtJikofutangaku12_core").val().replace(/,/g,"");
            var val1 =  $("#txtJikofutangaku1_core").val().replace(/,/g,"");
            var val2 =  $("#txtJikofutangaku2_core").val().replace(/,/g,"");
            var val3 =  $("#txtJikofutangaku3_core").val().replace(/,/g,"");
            var val4 =  $("#txtJikofutangaku4_core").val().replace(/,/g,"");
            var val5 =  $("#txtJikofutangaku5_core").val().replace(/,/g,"");
            var val6 =  $("#txtJikofutangaku6_core").val().replace(/,/g,"");
            var val7 =  $("#txtJikofutangaku7_core").val().replace(/,/g,"");

            $("#txtJikofutangakuGokei_core").val(fmoney( Number(val1)+Number(val2)+Number(val3)
                       +Number(val4)+Number(val5)+Number(val6)+Number(val7)+Number(val8)+Number(val9)
                       +Number(val10)+Number(val11)+Number(val12),0));
         });
          $("#txtJikofutangaku6").on("onBlur", function() {
             var val8 =  $("#txtJikofutangaku8_core").val().replace(/,/g,"");
            var val9 =  $("#txtJikofutangaku9_core").val().replace(/,/g,"");
            var val10 =  $("#txtJikofutangaku10_core").val().replace(/,/g,"");
            var val11 =  $("#txtJikofutangaku11_core").val().replace(/,/g,"");
            var val12 =  $("#txtJikofutangaku12_core").val().replace(/,/g,"");
            var val1 =  $("#txtJikofutangaku1_core").val().replace(/,/g,"");
            var val2 =  $("#txtJikofutangaku2_core").val().replace(/,/g,"");
            var val3 =  $("#txtJikofutangaku3_core").val().replace(/,/g,"");
            var val4 =  $("#txtJikofutangaku4_core").val().replace(/,/g,"");
            var val5 =  $("#txtJikofutangaku5_core").val().replace(/,/g,"");
            var val6 =  $("#txtJikofutangaku6_core").val().replace(/,/g,"");
            var val7 =  $("#txtJikofutangaku7_core").val().replace(/,/g,"");

            $("#txtJikofutangakuGokei_core").val(fmoney( Number(val1)+Number(val2)+Number(val3)
                       +Number(val4)+Number(val5)+Number(val6)+Number(val7)+Number(val8)+Number(val9)
                       +Number(val10)+Number(val11)+Number(val12),0));
         });
          $("#txtJikofutangaku7").on("onBlur", function() {
              var val8 =  $("#txtJikofutangaku8_core").val().replace(/,/g,"");
            var val9 =  $("#txtJikofutangaku9_core").val().replace(/,/g,"");
            var val10 =  $("#txtJikofutangaku10_core").val().replace(/,/g,"");
            var val11 =  $("#txtJikofutangaku11_core").val().replace(/,/g,"");
            var val12 =  $("#txtJikofutangaku12_core").val().replace(/,/g,"");
            var val1 =  $("#txtJikofutangaku1_core").val().replace(/,/g,"");
            var val2 =  $("#txtJikofutangaku2_core").val().replace(/,/g,"");
            var val3 =  $("#txtJikofutangaku3_core").val().replace(/,/g,"");
            var val4 =  $("#txtJikofutangaku4_core").val().replace(/,/g,"");
            var val5 =  $("#txtJikofutangaku5_core").val().replace(/,/g,"");
            var val6 =  $("#txtJikofutangaku6_core").val().replace(/,/g,"");
            var val7 =  $("#txtJikofutangaku7_core").val().replace(/,/g,"");

            $("#txtJikofutangakuGokei_core").val(fmoney( Number(val1)+Number(val2)+Number(val3)
                       +Number(val4)+Number(val5)+Number(val6)+Number(val7)+Number(val8)+Number(val9)
                       +Number(val10)+Number(val11)+Number(val12),0));
         });
};